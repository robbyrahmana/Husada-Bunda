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

import com.cinovation.web.entity.maintenance.WorkEntity;
import com.cinovation.web.repository.maintenance.WorkRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class WorkServiceImpl implements WorkService{
	private static final Logger logger = Logger.getLogger(WorkServiceImpl.class);
	
	@Autowired
	WorkRepository workRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheWork")
	public Page<WorkEntity> getWorkTable(Pageable pageable) {
		logger.info("");
		return workRepository.findByOrderByWorkAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheWork")
	public List<WorkEntity> getWorkList() {
		return workRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheWork", key="#ID")
	public WorkEntity getWorkListById(String ID) {
		return workRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheWork", allEntries=true)
	public WorkEntity saveWork(WorkEntity dataContainer) throws Exception {
		WorkEntity duplicate = workRepository.findByWork(dataContainer.getWork());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return workRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheWork", allEntries=true)
	public WorkEntity updateWork(WorkEntity dataContainer) throws Exception {
		WorkEntity data = workRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setWork(dataContainer.getWork());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return workRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public WorkEntity deleteWorkById(String ID) throws Exception {
		WorkEntity data = workRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return workRepository.saveAndFlush(data);	
	}
}
