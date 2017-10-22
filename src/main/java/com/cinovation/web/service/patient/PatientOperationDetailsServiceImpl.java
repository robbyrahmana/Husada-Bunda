package com.cinovation.web.service.patient;

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

import com.cinovation.web.constant.ApplicationConstants;
import com.cinovation.web.entity.patient.PatientOperationDetailsEntity;
import com.cinovation.web.repository.StatusRepository;
import com.cinovation.web.repository.patient.PatientOperationRepository;
import com.cinovation.web.repository.patient.PatientOperationDetailsRepository;
import com.cinovation.web.repository.treatment.TreatmentBodyRepository;
import com.cinovation.web.repository.treatment.TreatmentHeaderRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.treatment.TreatmentBodyService;
import com.cinovation.web.service.treatment.TreatmentHeaderService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientOperationDetailsServiceImpl implements PatientOperationDetailsService{
	private static final Logger logger = Logger.getLogger(PatientOperationDetailsServiceImpl.class);
	
	@Autowired
	PatientOperationDetailsRepository patientOperationDetailsRepository;
	
	@Inject
	PatientOperationService patientOperationService;
	
	@Inject
	TreatmentHeaderService treatmentHeaderService;
	
	@Inject
	TreatmentBodyService treatmentBodyService;

	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<PatientOperationDetailsEntity> getPatientOperationDetailsTable(String filter1, Pageable pageable) {
		logger.info("");
		return patientOperationDetailsRepository.findByPatientOperationEntityIdContainingOrderByCreateDateDesc(filter1, pageable);
	}
	
	@Override
	@Transactional
	public Page<PatientOperationDetailsEntity> getPatientOperationDetailsTableByDokterId(String filter1, Pageable pageable) {
		logger.info("");
		return patientOperationDetailsRepository.findByFunctionalityEntityIdOrderByCreateDateDesc(filter1, pageable);
	}
	
	@Override
	@Transactional
	public List<PatientOperationDetailsEntity> getPatientOperationDetailsList() {
		return patientOperationDetailsRepository.findAll();
	}
	
	@Override
	@Transactional
	public PatientOperationDetailsEntity getPatientOperationDetailsListById(String ID) {
		return patientOperationDetailsRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientOperationDetailsEntity savePatientOperationDetails(PatientOperationDetailsEntity dataContainer) throws Exception {
		PatientOperationDetailsEntity duplicate = patientOperationDetailsRepository.findByPatientOperationEntityIdAndTreatmentBodyEntityId(dataContainer.getPatientOperationEntity().getId(), dataContainer.getTreatmentBodyEntity().getId());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setTreatmentHeaderEntity(treatmentHeaderService.getTreatmentHeaderListById(dataContainer.getTreatmentBodyEntity().getTreatmentHeaderEntity().getId()));
		dataContainer.setCost(dataContainer.getTreatmentBodyEntity().getCost());
		dataContainer.setDoktercost(dataContainer.getTreatmentBodyEntity().getDoktercost());
		dataContainer.setStatus(statusRepository.findByCd(ApplicationConstants.STATUS_UNPAID));

		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return patientOperationDetailsRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientOperationDetailsEntity updatePatientOperationDetails(PatientOperationDetailsEntity dataContainer) throws Exception {
		PatientOperationDetailsEntity data = patientOperationDetailsRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setTreatmentHeaderEntity(treatmentHeaderService.getTreatmentHeaderListById(dataContainer.getTreatmentBodyEntity().getTreatmentHeaderEntity().getId()));
		data.setTreatmentBodyEntity(treatmentBodyService.getTreatmentBodyListById(dataContainer.getTreatmentBodyEntity().getId()));
		data.setCost(dataContainer.getTreatmentBodyEntity().getCost());
		data.setRemark(dataContainer.getRemark());
		data.setDoktercost(dataContainer.getTreatmentBodyEntity().getDoktercost());
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return patientOperationDetailsRepository.saveAndFlush(data);	
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientOperationDetailsEntity deletePatientOperationDetailsById(String ID) throws Exception {
		PatientOperationDetailsEntity data = patientOperationDetailsRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientOperationDetailsRepository.saveAndFlush(data);	
	}
}
