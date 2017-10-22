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

import com.cinovation.web.entity.maintenance.TribeEntity;
import com.cinovation.web.repository.maintenance.TribeRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class TribeServiceImpl implements TribeService{
	private static final Logger logger = Logger.getLogger(TribeServiceImpl.class);
	
	@Autowired
	TribeRepository tribeRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheTribe")
	public Page<TribeEntity> getTribeTable(Pageable pageable) {
		logger.info("");
		return tribeRepository.findByOrderByTribeAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheTribe")
	public List<TribeEntity> getTribeList() {
		return tribeRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheTribe", key="#ID")
	public TribeEntity getTribeListById(String ID) {
		return tribeRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheTribe", allEntries=true)
	public TribeEntity saveTribe(TribeEntity dataContainer) throws Exception {
		TribeEntity duplicate = tribeRepository.findByTribe(dataContainer.getTribe());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return tribeRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheTribe", allEntries=true)
	public TribeEntity updateTribe(TribeEntity dataContainer) throws Exception {
		TribeEntity data = tribeRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setTribe(dataContainer.getTribe());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return tribeRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TribeEntity deleteTribeById(String ID) throws Exception {
		TribeEntity data = tribeRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return tribeRepository.saveAndFlush(data);	
	}
}
