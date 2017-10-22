package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientEntity;

public interface PatientService {

	Page<PatientEntity> getPatientTable(String filter1, String filter2, Pageable pageable);
	
	List<PatientEntity> getPatientList();
	
	PatientEntity getPatientListById(String ID);
	
	PatientEntity savePatient(PatientEntity dataContainer) throws Exception;
	
	PatientEntity updatePatient(PatientEntity dataContainer) throws Exception;
	
	PatientEntity deletePatientById(String ID) throws Exception;
}
