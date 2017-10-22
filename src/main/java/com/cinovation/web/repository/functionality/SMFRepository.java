package com.cinovation.web.repository.functionality;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.functionality.SMFEntity;

public interface SMFRepository extends JpaRepository<SMFEntity, String> {
	
	Page<SMFEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	SMFEntity findByCdOrName(String cd, String name);
}
