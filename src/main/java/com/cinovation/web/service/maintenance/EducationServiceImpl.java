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

import com.cinovation.web.entity.maintenance.EducationEntity;
import com.cinovation.web.repository.maintenance.EducationRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class EducationServiceImpl implements EducationService{
	private static final Logger logger = Logger.getLogger(EducationServiceImpl.class);
	
	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheEducation")
	public Page<EducationEntity> getEducationTable(Pageable pageable) {
		logger.info("");
		return educationRepository.findByOrderByEducationAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheEducation")
	public List<EducationEntity> getEducationList() {
		return educationRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheEducation", key="#ID")
	public EducationEntity getEducationListById(String ID) {
		return educationRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheEducation", allEntries = true)
	public EducationEntity saveEducation(EducationEntity dataContainer) throws Exception {
		EducationEntity duplicate = educationRepository.findByEducation(dataContainer.getEducation());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return educationRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheEducation", allEntries = true)
	public EducationEntity updateEducation(EducationEntity dataContainer) throws Exception {
		EducationEntity data = educationRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setEducation(dataContainer.getEducation());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return educationRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public EducationEntity deleteEducationById(String ID) throws Exception {
		EducationEntity data = educationRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return educationRepository.saveAndFlush(data);	
	}
}
