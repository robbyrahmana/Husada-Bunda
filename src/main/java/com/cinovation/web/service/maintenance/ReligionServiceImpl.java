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

import com.cinovation.web.entity.maintenance.ReligionEntity;
import com.cinovation.web.repository.maintenance.ReligionRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class ReligionServiceImpl implements ReligionService{
	
	private static final Logger logger = Logger.getLogger(ReligionServiceImpl.class);
	
	@Autowired
	ReligionRepository religionRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheReligion")
	public Page<ReligionEntity> getReligionTable(Pageable pageable) {
		logger.info("");
		return religionRepository.findByOrderByReligionAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheReligion")
	public List<ReligionEntity> getReligionList() {
		return religionRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheReligion", key="#ID")
	public ReligionEntity getReligionListById(String ID) {
		return religionRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheReligion", allEntries=true)
	public ReligionEntity saveReligion(ReligionEntity dataContainer) throws Exception {
		ReligionEntity duplicate = religionRepository.findByReligion(dataContainer.getReligion());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return religionRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheReligion", allEntries=true)
	public ReligionEntity updateReligion(ReligionEntity dataContainer) throws Exception {
		ReligionEntity data = religionRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setReligion(dataContainer.getReligion());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return religionRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public ReligionEntity deleteReligionById(String ID) throws Exception {
		ReligionEntity data = religionRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return religionRepository.saveAndFlush(data);	
	}
	
}
