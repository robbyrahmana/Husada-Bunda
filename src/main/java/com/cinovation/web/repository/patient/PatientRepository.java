package com.cinovation.web.repository.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, String> {
	
	Page<PatientEntity> findByRefnopatientContainingAndNameContainingOrderByCreateDateDesc(String filter1, String filter2, Pageable pageable);
	
	PatientEntity findByName(String name);
}
