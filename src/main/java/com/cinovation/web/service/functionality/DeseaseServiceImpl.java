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

import com.cinovation.web.entity.functionality.DeseaseEntity;
import com.cinovation.web.repository.functionality.DeseaseRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class DeseaseServiceImpl implements DeseaseService{
	
	private static final Logger logger = Logger.getLogger(DeseaseServiceImpl.class);
	
	@Autowired
	DeseaseRepository deseaseRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<DeseaseEntity> getDeseaseTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return deseaseRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<DeseaseEntity> getDeseaseList() {
		return deseaseRepository.findAll();
	}
	
	@Override
	public DeseaseEntity getDeseaseListById(String ID) {
		return deseaseRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public DeseaseEntity saveDesease(DeseaseEntity dataContainer) throws Exception {
		DeseaseEntity duplicate = deseaseRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return deseaseRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public DeseaseEntity updateDesease(DeseaseEntity dataContainer) throws Exception {
		DeseaseEntity data = deseaseRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return deseaseRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public DeseaseEntity deleteDeseaseById(String ID) throws Exception {
		DeseaseEntity data = deseaseRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return deseaseRepository.saveAndFlush(data);	
	}

}
