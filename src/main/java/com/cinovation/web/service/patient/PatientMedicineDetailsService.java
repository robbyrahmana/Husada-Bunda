package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientMedicineDetailsEntity;

public interface PatientMedicineDetailsService {

	Page<PatientMedicineDetailsEntity> getPatientMedicineDetailsTable(String filter1, Pageable pageable);
	
	List<PatientMedicineDetailsEntity> getPatientMedicineDetailsList();
	
	PatientMedicineDetailsEntity getPatientMedicineDetailsListById(String ID);
	
	PatientMedicineDetailsEntity savePatientMedicineDetails(PatientMedicineDetailsEntity dataContainer) throws Exception;
	
	PatientMedicineDetailsEntity updatePatientMedicineDetails(PatientMedicineDetailsEntity dataContainer) throws Exception;
	
	PatientMedicineDetailsEntity deletePatientMedicineDetailsById(String ID) throws Exception;
}
