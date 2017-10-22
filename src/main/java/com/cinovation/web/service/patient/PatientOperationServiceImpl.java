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
import com.cinovation.web.entity.patient.PatientOperationEntity;
import com.cinovation.web.repository.functionality.FunctionalityRepository;
import com.cinovation.web.repository.patient.PatientOperationRepository;
import com.cinovation.web.repository.treatment.TreatmentBodyRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.functionality.FunctionalityService;
import com.cinovation.web.service.treatment.TreatmentBodyService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientOperationServiceImpl implements PatientOperationService{

	private static final Logger logger = Logger.getLogger(PatientOperationServiceImpl.class);
	
	@Autowired
	PatientOperationRepository patientOperationRepository;
	
	@Inject
	FunctionalityService functionalityService;
	
	@Inject
	TreatmentBodyService treatmentBodyService;
	
	@Inject
	PatientOperationDetailsService patientOperationDetailsService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PatientOperationEntity> getPatientOperationTable(String filter1, String filter2, String filter3, Pageable pageable) {
		logger.info(filter3);
		if(filter3.equalsIgnoreCase(ApplicationConstants.ALL_RECORD)) {
			return patientOperationRepository.findByPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc(filter1, filter2, pageable);
		} else {
			return patientOperationRepository.findByPatientAdministrationEntityIdOrderByCreateDateDesc(filter3, pageable);
		}

	}
	
	@Override
	public List<PatientOperationEntity> getPatientOperationList() {
		return patientOperationRepository.findAll();
	}
	
	@Override
	public PatientOperationEntity getPatientOperationListById(String ID) {
		return patientOperationRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientOperationEntity savePatientOperation(PatientOperationEntity dataContainer) throws Exception {
		
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		PatientOperationEntity rtn = patientOperationRepository.saveAndFlush(dataContainer);
		
		/* Insert to operatio detail treatment body*/
		// TIM
		PatientOperationDetailsEntity tim = new PatientOperationDetailsEntity();
		tim.setPatientOperationEntity(rtn);
		tim.setTreatmentBodyEntity(treatmentBodyService.getTreatmentBodyListById(ApplicationConstants.TREATMENT_BODY_TIM_OPERASI));
		tim = patientOperationDetailsService.savePatientOperationDetails(tim);

		// kamar
		PatientOperationDetailsEntity kamar = new PatientOperationDetailsEntity();
		kamar.setPatientOperationEntity(rtn);
		kamar.setTreatmentBodyEntity(treatmentBodyService.getTreatmentBodyListById(ApplicationConstants.TREATMENT_BODY_KAMAR_OPERASI));
		kamar = patientOperationDetailsService.savePatientOperationDetails(kamar);

		// Operasi SC
		PatientOperationDetailsEntity operasi = new PatientOperationDetailsEntity();
		operasi.setPatientOperationEntity(rtn);
		operasi.setTreatmentBodyEntity(treatmentBodyService.getTreatmentBodyListById(ApplicationConstants.TREATMENT_BODY_OPERASI_SC));
		operasi.setFunctionalityEntity(functionalityService.getFunctionalityListById(dataContainer.getFunctionalityEntity().getId()));
		operasi = patientOperationDetailsService.savePatientOperationDetails(operasi);

		return rtn;
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientOperationEntity deletePatientOperationById(String ID) throws Exception {
		PatientOperationEntity data = patientOperationRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientOperationRepository.saveAndFlush(data);	
	}
}
