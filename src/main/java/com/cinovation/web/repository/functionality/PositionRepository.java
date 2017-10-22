package com.cinovation.web.repository.functionality;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.functionality.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, String> {
	
	Page<PositionEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	PositionEntity findByCdOrName(String cd, String name);
}
