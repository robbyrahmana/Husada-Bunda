package com.cinovation.web.service.treatment;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.treatment.TreatmentBodyEntity;
import com.cinovation.web.repository.treatment.ProductRepository;
import com.cinovation.web.repository.treatment.TreatmentBodyRepository;
import com.cinovation.web.repository.treatment.TreatmentHeaderRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class TreatmentBodyServiceImpl implements TreatmentBodyService{

	private static final Logger logger = Logger.getLogger(TreatmentBodyServiceImpl.class);
	
	@Autowired
	TreatmentBodyRepository treatmentBodyRepository;
	
	@Inject
	TreatmentHeaderService treatmentHeaderService;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<TreatmentBodyEntity> getTreatmentBodyTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return treatmentBodyRepository.findByCdContainingAndNameContainingOrderByTreatmentHeaderEntityCdAscCdAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<TreatmentBodyEntity> getTreatmentBodyList() {
		return treatmentBodyRepository.findAll();
	}
	
	@Override
	public TreatmentBodyEntity getTreatmentBodyListById(String ID) {
		return treatmentBodyRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public TreatmentBodyEntity saveTreatmentBody(TreatmentBodyEntity dataContainer) throws Exception {
		TreatmentBodyEntity duplicate = treatmentBodyRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return treatmentBodyRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TreatmentBodyEntity updateTreatmentBody(TreatmentBodyEntity dataContainer) throws Exception {
		TreatmentBodyEntity data = treatmentBodyRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setCost(dataContainer.getCost());
		data.setDoktercost(dataContainer.getDoktercost());
		data.setRemark(dataContainer.getRemark());
		data.setTreatmentHeaderEntity(treatmentHeaderService.getTreatmentHeaderListById(dataContainer.getTreatmentHeaderEntity().getId()));
		data.setProductEntity(productRepository.findOne(dataContainer.getProductEntity().getId()));
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return treatmentBodyRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public TreatmentBodyEntity deleteTreatmentBodyById(String ID) throws Exception {
		TreatmentBodyEntity data = treatmentBodyRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return treatmentBodyRepository.saveAndFlush(data);	
	}
	
	@Override
	public List<TreatmentBodyEntity> getTreatmentBodyListByHeaderId(String ID) {
		return treatmentBodyRepository.findByTreatmentHeaderEntityId(ID);
	}
	
	@Override
	public List<TreatmentBodyEntity> getTreatmentBodyListByProductId(String ID) {
		logger.info("getTreatmentBodyListByHeaderListId");
		return treatmentBodyRepository.findByProductEntityId(ID);
	}
}
