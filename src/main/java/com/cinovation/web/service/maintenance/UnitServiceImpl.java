package com.cinovation.web.service.maintenance;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.maintenance.UnitEntity;
import com.cinovation.web.repository.maintenance.UnitRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class UnitServiceImpl implements UnitService{
	
private static final Logger logger = Logger.getLogger(UnitServiceImpl.class);
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheUnit")
	public Page<UnitEntity> getUnitTable(Pageable pageable) {
		logger.info("");
		return unitRepository.findByOrderByUnitAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheUnit")
	public List<UnitEntity> getUnitList() {
		return unitRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheUnit", key="#ID")
	public UnitEntity getUnitListById(String ID) {
		return unitRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheUnit", allEntries=true)
	public UnitEntity saveUnit(UnitEntity dataContainer) throws Exception {
		UnitEntity duplicate = unitRepository.findByUnit(dataContainer.getUnit());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return unitRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheUnit", allEntries=true)
	public UnitEntity updateUnit(UnitEntity dataContainer) throws Exception {
		UnitEntity data = unitRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setUnit(dataContainer.getUnit());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return unitRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public UnitEntity deleteUnitById(String ID) throws Exception {
		UnitEntity data = unitRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return unitRepository.saveAndFlush(data);	
	}
}
