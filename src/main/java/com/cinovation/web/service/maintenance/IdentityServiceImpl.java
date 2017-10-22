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

import com.cinovation.web.entity.maintenance.IdentityEntity;
import com.cinovation.web.repository.maintenance.IdentityRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class IdentityServiceImpl implements IdentityService{
	private static final Logger logger = Logger.getLogger(IdentityServiceImpl.class);
	
	@Autowired
	IdentityRepository identityRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheIdentity")
	public Page<IdentityEntity> getIdentityTable(Pageable pageable) {
		logger.info("");
		return identityRepository.findByOrderByIdentityAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheIdentity")
	public List<IdentityEntity> getIdentityList() {
		return identityRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheIdentity", key="#ID")
	public IdentityEntity getIdentityListById(String ID) {
		return identityRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheIdentity", allEntries=true)
	public IdentityEntity saveIdentity(IdentityEntity dataContainer) throws Exception {
		IdentityEntity duplicate = identityRepository.findByIdentity(dataContainer.getIdentity());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return identityRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheIdentity", allEntries=true)
	public IdentityEntity updateIdentity(IdentityEntity dataContainer) throws Exception {
		IdentityEntity data = identityRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setIdentity(dataContainer.getIdentity());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return identityRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public IdentityEntity deleteIdentityById(String ID) throws Exception {
		IdentityEntity data = identityRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return identityRepository.saveAndFlush(data);	
	}
}
