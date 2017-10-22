package com.cinovation.web.repository.patient;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientAdministrationEntity;

public interface PatientAdministrationRepository extends JpaRepository<PatientAdministrationEntity, String> {

	Page<PatientAdministrationEntity> findByPatientEntityRefnopatientContainingAndPatientEntityNameContainingAndInternalstatusCdContainingOrderByCreateDateAsc(String filter1, String filter2, String filter3, Pageable pageable);
	
	Page<PatientAdministrationEntity> findByFunctionalityEntityIdOrderByCreateDateAsc(String filter1, Pageable pageable);
	
	long countByCreateDate(Date date);
}
