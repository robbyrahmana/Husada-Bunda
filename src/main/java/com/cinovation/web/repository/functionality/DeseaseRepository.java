package com.cinovation.web.repository.functionality;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.functionality.DeseaseEntity;

public interface DeseaseRepository extends JpaRepository<DeseaseEntity, String> {
	
	Page<DeseaseEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	DeseaseEntity findByCdOrName(String cd, String name);
}
