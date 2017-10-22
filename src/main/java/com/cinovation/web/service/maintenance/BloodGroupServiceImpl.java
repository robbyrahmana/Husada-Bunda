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

import com.cinovation.web.entity.maintenance.BloodGroupEntity;
import com.cinovation.web.repository.maintenance.BloodGroupRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class BloodGroupServiceImpl implements BloodGroupService{
	
	private static final Logger logger = Logger.getLogger(BloodGroupServiceImpl.class);
	
	@Autowired
	BloodGroupRepository bloodGroupRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheBloodGroup")
	public Page<BloodGroupEntity> getBloodGroupTable(Pageable pageable) {
		logger.info("");
		return bloodGroupRepository.findByOrderByBloodgroupAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheBloodGroup")
	public List<BloodGroupEntity> getBloodGroupList() {
		return bloodGroupRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheBloodGroup", key="#ID")
	public BloodGroupEntity getBloodGroupListById(String ID) {
		return bloodGroupRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheBloodGroup", allEntries = true)
	public BloodGroupEntity saveBloodGroup(BloodGroupEntity dataContainer) throws Exception {
		BloodGroupEntity duplicate = bloodGroupRepository.findByBloodgroup(dataContainer.getBloodgroup());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return bloodGroupRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheBloodGroup", allEntries = true)
	public BloodGroupEntity updateBloodGroup(BloodGroupEntity dataContainer) throws Exception {
		BloodGroupEntity data = bloodGroupRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setBloodgroup(dataContainer.getBloodgroup());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return bloodGroupRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public BloodGroupEntity deleteBloodGroupById(String ID) throws Exception {
		BloodGroupEntity data = bloodGroupRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return bloodGroupRepository.saveAndFlush(data);	
	}
	
}