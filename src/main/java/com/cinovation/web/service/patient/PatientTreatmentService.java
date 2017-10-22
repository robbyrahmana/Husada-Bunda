package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientTreatmentEntity;
import com.cinovation.web.validator.exception.RecordNotFoundException;

public interface PatientTreatmentService {
	
	Page<PatientTreatmentEntity> getPatientTreatmentTable(String filter1, String filter2, String filter3, Pageable pageable);
	
	List<PatientTreatmentEntity> getPatientTreatmentList();
	
	PatientTreatmentEntity getPatientTreatmentListById(String ID);
	
	PatientTreatmentEntity savePatientTreatment(PatientTreatmentEntity dataContainer) throws Exception;
	
	PatientTreatmentEntity updatePatientTreatment(PatientTreatmentEntity dataContainer) throws Exception;
	
	PatientTreatmentEntity deletePatientTreatmentById(String ID) throws Exception;

	Page<PatientTreatmentEntity> getPatientTreatmentTableByDokterId(String filter1, Pageable pageable);
	
}
