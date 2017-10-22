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

import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.repository.maintenance.GenderRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class GenderServiceImpl implements GenderService{
	
	private static final Logger logger = Logger.getLogger(GenderServiceImpl.class);
	
	@Autowired
	GenderRepository genderRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheGender")
	public Page<GenderEntity> getGenderTable(Pageable pageable) {
		logger.info("");
		return genderRepository.findByOrderByGenderAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheGender")
	public List<GenderEntity> getGenderList() {
		return genderRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheGender", key="#ID")
	public GenderEntity getGenderListById(String ID) {
		return genderRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheGender", allEntries = true)
	public GenderEntity saveGender(GenderEntity dataContainer) throws Exception {
		GenderEntity duplicate = genderRepository.findByGender(dataContainer.getGender());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return genderRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheGender", allEntries = true)
	public GenderEntity updateGender(GenderEntity dataContainer) throws Exception {
		GenderEntity data = genderRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setGender(dataContainer.getGender());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return genderRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public GenderEntity deleteGenderById(String ID) throws Exception {
		GenderEntity data = genderRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return genderRepository.saveAndFlush(data);	
	}
}
