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

import com.cinovation.web.entity.maintenance.RhesusEntity;
import com.cinovation.web.repository.maintenance.RhesusRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class RhesusServiceImpl implements RhesusService{
	private static final Logger logger = Logger.getLogger(RhesusServiceImpl.class);
	
	@Autowired
	RhesusRepository rhesusRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheRhesus")
	public Page<RhesusEntity> getRhesusTable(Pageable pageable) {
		logger.info("");
		return rhesusRepository.findByOrderByRhesusAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheRhesus")
	public List<RhesusEntity> getRhesusList() {
		return rhesusRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheRhesus", key="#ID")
	public RhesusEntity getRhesusListById(String ID) {
		return rhesusRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheRhesus", allEntries=true)
	public RhesusEntity saveRhesus(RhesusEntity dataContainer) throws Exception {
		RhesusEntity duplicate = rhesusRepository.findByRhesus(dataContainer.getRhesus());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return rhesusRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheRhesus", allEntries=true)
	public RhesusEntity updateRhesus(RhesusEntity dataContainer) throws Exception {
		RhesusEntity data = rhesusRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setRhesus(dataContainer.getRhesus());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return rhesusRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RhesusEntity deleteRhesusById(String ID) throws Exception {
		RhesusEntity data = rhesusRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return rhesusRepository.saveAndFlush(data);	
	}
}
