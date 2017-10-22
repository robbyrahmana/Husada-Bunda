package com.cinovation.web.service.patient;

import java.text.ParseException;
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
import com.cinovation.web.entity.patient.PatientTreatmentEntity;
import com.cinovation.web.repository.StatusRepository;
import com.cinovation.web.repository.patient.PatientTreatmentRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.functionality.FunctionalityService;
import com.cinovation.web.service.treatment.TreatmentBodyService;
import com.cinovation.web.service.treatment.TreatmentHeaderService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientTreatmentServiceImpl implements PatientTreatmentService{

	private static final Logger logger = Logger.getLogger(PatientTreatmentServiceImpl.class);
	
	@Autowired
	PatientTreatmentRepository patientTreatmentRepository;
	
	@Inject
	TreatmentBodyService treatmentBodyService;
	
	@Inject
	TreatmentHeaderService treatmentHeaderService;
	
	@Inject
	FunctionalityService functionalityService;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<PatientTreatmentEntity> getPatientTreatmentTable(String filter1, String filter2, String filter3, Pageable pageable) {
		logger.info(filter3);
		if (filter3.equalsIgnoreCase(ApplicationConstants.ALL_RECORD)) {
			return patientTreatmentRepository.findByPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateAsc(filter1, filter2, pageable);
		} else {
			return patientTreatmentRepository.findByPatientAdministrationEntityIdOrderByCreateDateAsc(filter3, pageable);
		}
		
	}
	
	@Override
	@Transactional
	public Page<PatientTreatmentEntity> getPatientTreatmentTableByDokterId(String filter1, Pageable pageable) {
		logger.info("");

		return patientTreatmentRepository.findByFunctionalityEntityIdOrderByCreateDateAsc(filter1, pageable);
		
	}
	
	@Override
	@Transactional
	public List<PatientTreatmentEntity> getPatientTreatmentList() {
		return patientTreatmentRepository.findAll();
	}
	
	@Override
	@Transactional
	public PatientTreatmentEntity getPatientTreatmentListById(String ID) {
		return patientTreatmentRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientTreatmentEntity savePatientTreatment(PatientTreatmentEntity dataContainer) throws Exception {

		dataContainer.setTreatmentHeaderEntity(treatmentHeaderService.getTreatmentHeaderListById(dataContainer.getTreatmentBodyEntity().getTreatmentHeaderEntity().getId()));
		dataContainer.setCost(dataContainer.getTreatmentBodyEntity().getCost());
		dataContainer.setDoktercost(dataContainer.getTreatmentBodyEntity().getDoktercost());
		
		dataContainer.setStatus(statusRepository.findByCd(ApplicationConstants.STATUS_UNPAID));
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return patientTreatmentRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientTreatmentEntity updatePatientTreatment(PatientTreatmentEntity dataContainer) throws Exception {
		PatientTreatmentEntity data = patientTreatmentRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setTreatmentHeaderEntity(treatmentHeaderService.getTreatmentHeaderListById(dataContainer.getTreatmentBodyEntity().getTreatmentHeaderEntity().getId()));
		data.setTreatmentBodyEntity(treatmentBodyService.getTreatmentBodyListById(dataContainer.getTreatmentBodyEntity().getId()));
		if (dataContainer.getFunctionalityEntity() != null) data.setFunctionalityEntity(functionalityService.getFunctionalityListById(dataContainer.getFunctionalityEntity().getId()));
		data.setCost(dataContainer.getTreatmentBodyEntity().getCost());
		data.setDoktercost(dataContainer.getTreatmentBodyEntity().getDoktercost());
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return patientTreatmentRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientTreatmentEntity deletePatientTreatmentById(String ID) throws Exception {
		PatientTreatmentEntity data = patientTreatmentRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientTreatmentRepository.saveAndFlush(data);	
	}
}
