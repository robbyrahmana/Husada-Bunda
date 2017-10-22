package com.cinovation.web.repository.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientOperationEntity;

public interface PatientOperationRepository extends JpaRepository<PatientOperationEntity, String> {

	Page<PatientOperationEntity> findByPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc(String filter1, String filter2, Pageable pageable);
	
	Page<PatientOperationEntity> findByPatientAdministrationEntityIdOrderByCreateDateDesc(String filter1, Pageable pageable);
	
	PatientOperationEntity findByPatientAdministrationEntityId(String id);
}
