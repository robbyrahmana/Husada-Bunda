package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientOperationEntity;

public interface PatientOperationService {

	Page<PatientOperationEntity> getPatientOperationTable(String filter1, String filter2, String filter3, Pageable pageable);
	
	List<PatientOperationEntity> getPatientOperationList();
	
	PatientOperationEntity getPatientOperationListById(String ID);
	
	PatientOperationEntity savePatientOperation(PatientOperationEntity dataContainer) throws Exception;
	
	PatientOperationEntity deletePatientOperationById(String ID) throws Exception;
}
