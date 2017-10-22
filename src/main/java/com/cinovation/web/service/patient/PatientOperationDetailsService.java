package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientOperationDetailsEntity;
import com.cinovation.web.validator.exception.RecordNotFoundException;

public interface PatientOperationDetailsService {
	Page<PatientOperationDetailsEntity> getPatientOperationDetailsTable(String filter1, Pageable pageable);
	
	List<PatientOperationDetailsEntity> getPatientOperationDetailsList();
	
	PatientOperationDetailsEntity getPatientOperationDetailsListById(String ID);
	
	PatientOperationDetailsEntity savePatientOperationDetails(PatientOperationDetailsEntity dataContainer) throws Exception;
	
	PatientOperationDetailsEntity updatePatientOperationDetails(PatientOperationDetailsEntity dataContainer) throws Exception;
	
	PatientOperationDetailsEntity deletePatientOperationDetailsById(String ID) throws Exception;

	Page<PatientOperationDetailsEntity> getPatientOperationDetailsTableByDokterId(String filter1, Pageable pageable);
}
