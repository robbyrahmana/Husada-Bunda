package com.cinovation.web.repository.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientOperationDetailsEntity;

public interface PatientOperationDetailsRepository extends JpaRepository<PatientOperationDetailsEntity, String> {

	Page<PatientOperationDetailsEntity> findByPatientOperationEntityIdContainingOrderByCreateDateDesc(String filter1, Pageable pageable);
	
	Page<PatientOperationDetailsEntity> findByFunctionalityEntityIdOrderByCreateDateDesc(String filter1, Pageable pageable);
	
	PatientOperationDetailsEntity findByPatientOperationEntityIdAndTreatmentBodyEntityId(String patient, String body);
}
