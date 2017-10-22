package com.cinovation.web.repository.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientTreatmentEntity;

public interface PatientTreatmentRepository extends JpaRepository<PatientTreatmentEntity, String> {

	Page<PatientTreatmentEntity> findByPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateAsc(String filter1, String filter2, Pageable pageable);
	
	Page<PatientTreatmentEntity> findByFunctionalityEntityIdOrderByCreateDateAsc(String filter1, Pageable pageable);
	
	Page<PatientTreatmentEntity> findByPatientAdministrationEntityIdOrderByCreateDateAsc(String filter1, Pageable pageable);
	
}
