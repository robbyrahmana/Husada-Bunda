package com.cinovation.web.repository.treatment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;

public interface TreatmentHeaderRepository extends JpaRepository<TreatmentHeaderEntity, String> {
	
	Page<TreatmentHeaderEntity> findByCdContainingAndNameContainingOrderByCdAsc(String filter1, String filter2, Pageable pageable);
	
	TreatmentHeaderEntity findByCdOrName(String cd, String name);
}
