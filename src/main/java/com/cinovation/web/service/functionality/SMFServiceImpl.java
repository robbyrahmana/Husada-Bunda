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

import com.cinovation.web.entity.functionality.SMFEntity;
import com.cinovation.web.repository.functionality.SMFRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class SMFServiceImpl implements SMFService {

	private static final Logger logger = Logger.getLogger(SMFServiceImpl.class);
	
	@Autowired
	SMFRepository sMFRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<SMFEntity> getSMFTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return sMFRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<SMFEntity> getSMFList() {
		return sMFRepository.findAll();
	}
	
	@Override
	public SMFEntity getSMFListById(String ID) {
		return sMFRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public SMFEntity saveSMF(SMFEntity dataContainer) throws Exception {
		SMFEntity duplicate = sMFRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return sMFRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public SMFEntity updateSMF(SMFEntity dataContainer) throws Exception {
		SMFEntity data = sMFRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return sMFRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public SMFEntity deleteSMFById(String ID) throws Exception {
		SMFEntity data = sMFRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return sMFRepository.saveAndFlush(data);	
	}
}
