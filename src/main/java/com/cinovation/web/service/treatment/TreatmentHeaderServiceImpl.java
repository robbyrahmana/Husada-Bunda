package com.cinovation.web.service.treatment;

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

import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;
import com.cinovation.web.repository.treatment.TreatmentHeaderRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class TreatmentHeaderServiceImpl implements TreatmentHeaderService{

	private static final Logger logger = Logger.getLogger(TreatmentHeaderServiceImpl.class);
	
	@Autowired
	TreatmentHeaderRepository treatmentHeaderRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<TreatmentHeaderEntity> getTreatmentHeaderTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return treatmentHeaderRepository.findByCdContainingAndNameContainingOrderByCdAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<TreatmentHeaderEntity> getTreatmentHeaderList() {
		return treatmentHeaderRepository.findAll();
	}
	
	@Override
	public TreatmentHeaderEntity getTreatmentHeaderListById(String ID) {
		return treatmentHeaderRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public TreatmentHeaderEntity saveTreatmentHeader(TreatmentHeaderEntity dataContainer) throws Exception {
		TreatmentHeaderEntity duplicate = treatmentHeaderRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setShowbody(1);
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return treatmentHeaderRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TreatmentHeaderEntity updateTreatmentHeader(TreatmentHeaderEntity dataContainer) throws Exception {
		TreatmentHeaderEntity data = treatmentHeaderRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setShowbody(dataContainer.getShowbody());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return treatmentHeaderRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TreatmentHeaderEntity deleteTreatmentHeaderById(String ID) throws Exception {
		TreatmentHeaderEntity data = treatmentHeaderRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return treatmentHeaderRepository.saveAndFlush(data);	
	}
}
