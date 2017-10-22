package com.cinovation.web.service.maintenance;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.maintenance.RelationshipEntity;
import com.cinovation.web.repository.maintenance.RelationshipRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class RelationshipServiceImpl implements RelationshipService{
	private static final Logger logger = Logger.getLogger(RelationshipServiceImpl.class);
	
	@Autowired
	RelationshipRepository relationshipRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheRelationship")
	public Page<RelationshipEntity> getRelationshipTable(Pageable pageable) {
		logger.info("");
		return relationshipRepository.findByOrderByRelationshipAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheRelationship")
	public List<RelationshipEntity> getRelationshipList() {
		return relationshipRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheRelationship", key="#ID")
	public RelationshipEntity getRelationshipListById(String ID) {
		return relationshipRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public RelationshipEntity saveRelationship(RelationshipEntity dataContainer) throws Exception {
		RelationshipEntity duplicate = relationshipRepository.findByRelationship(dataContainer.getRelationship());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return relationshipRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RelationshipEntity updateRelationship(RelationshipEntity dataContainer) throws Exception {
		RelationshipEntity data = relationshipRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setRelationship(dataContainer.getRelationship());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return relationshipRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RelationshipEntity deleteRelationshipById(String ID) throws Exception {
		RelationshipEntity data = relationshipRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return relationshipRepository.saveAndFlush(data);	
	}
}
