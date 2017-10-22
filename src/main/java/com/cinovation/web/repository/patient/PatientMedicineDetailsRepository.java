package com.cinovation.web.repository.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinovation.web.entity.patient.PatientMedicineDetailsEntity;

public interface PatientMedicineDetailsRepository extends JpaRepository<PatientMedicineDetailsEntity, String> {

	Page<PatientMedicineDetailsEntity> findByPatientMedicineEntityIdContainingOrderByCreateDateDesc(String filter1, Pageable pageable);
	
	@Query("select sum(data.cost) from PatientMedicineDetailsEntity data WHERE data.medicineEntity.id=?1 group by data.medicineEntity")
	String findSummTotalByMedicineEntity(String ID);
}
