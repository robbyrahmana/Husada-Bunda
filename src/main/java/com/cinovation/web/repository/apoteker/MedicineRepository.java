package com.cinovation.web.repository.apoteker;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.apoteker.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, String> {
	
	Page<MedicineEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	MedicineEntity findByCdOrName(String cd, String name);
}
