package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientAdministrationEntity;

public interface PatientAdministrationService {
	
	Page<PatientAdministrationEntity> getPatientAdministrationTable(String filter1, String filter2, String filter3, Pageable pageable);
	
	List<PatientAdministrationEntity> getPatientAdministrationList();
	
	PatientAdministrationEntity getPatientAdministrationListById(String ID);
	
	String getRegistrationCode(String ID);
	
	PatientAdministrationEntity savePatientAdministration(PatientAdministrationEntity dataContainer) throws Exception;
	
	PatientAdministrationEntity deletePatientAdministrationById(String ID, String remark) throws Exception;

	Page<PatientAdministrationEntity> getPatientAdministrationTableByDokterId(String filter1, Pageable pageable);
	
	PatientAdministrationEntity updateStatusById(String id) throws Exception;
}
