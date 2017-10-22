package com.cinovation.web.service.functionality;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.functionality.PositionEntity;
import com.cinovation.web.repository.functionality.PositionRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PositionServiceImpl implements PositionService{

	private static final Logger logger = Logger.getLogger(PositionServiceImpl.class);
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PositionEntity> getPositionTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return positionRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<PositionEntity> getPositionList() {
		return positionRepository.findAll();
	}
	
	@Override
	public PositionEntity getPositionListById(String ID) {
		return positionRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PositionEntity savePosition(PositionEntity dataContainer) throws Exception {
		PositionEntity duplicate = positionRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return positionRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PositionEntity updatePosition(PositionEntity dataContainer) throws Exception {
		PositionEntity data = positionRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return positionRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PositionEntity deletePositionById(String ID) throws Exception {
		PositionEntity data = positionRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return positionRepository.saveAndFlush(data);	
	}
}
