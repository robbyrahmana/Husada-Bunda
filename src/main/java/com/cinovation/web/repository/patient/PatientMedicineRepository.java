package com.cinovation.web.repository.patient;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.patient.PatientMedicineEntity;

public interface PatientMedicineRepository extends JpaRepository<PatientMedicineEntity, String> {

	Page<PatientMedicineEntity> findByRefnomedicineContainingAndPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc(String filter1, String filter2, String filter3, Pageable pageable);
	
	Page<PatientMedicineEntity> findByPatientAdministrationEntityIdOrderByCreateDateDesc(String filter1, Pageable pageable);
	
	Page<PatientMedicineEntity> findByStatusIdAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc( String filter1, String filter2, Pageable pageable);
	
	long countByCreateDate(Date date);
}
