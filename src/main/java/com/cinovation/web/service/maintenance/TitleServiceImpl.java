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

import com.cinovation.web.entity.maintenance.TitleEntity;
import com.cinovation.web.repository.maintenance.TitleRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class TitleServiceImpl implements TitleService{
	
	private static final Logger logger = Logger.getLogger(TitleServiceImpl.class);
	
	@Autowired
	TitleRepository titleRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheTitle")
	public Page<TitleEntity> getTitleTable(Pageable pageable) {
		logger.info("");
		return titleRepository.findByOrderByTitleAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheTitle")
	public List<TitleEntity> getTitleList() {
		return titleRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheTitle", key="#ID")
	public TitleEntity getTitleListById(String ID) {
		return titleRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheTitle", allEntries=true)
	public TitleEntity saveTitle(TitleEntity dataContainer) throws Exception {
		TitleEntity duplicate = titleRepository.findByTitle(dataContainer.getTitle());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return titleRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheTitle", allEntries=true)
	public TitleEntity updateTitle(TitleEntity dataContainer) throws Exception {
		TitleEntity data = titleRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setTitle(dataContainer.getTitle());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return titleRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TitleEntity deleteTitleById(String ID) throws Exception {
		TitleEntity data = titleRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return titleRepository.saveAndFlush(data);	
	}
	
}
