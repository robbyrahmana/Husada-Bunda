package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.UnitEntity;

public interface UnitRepository extends JpaRepository<UnitEntity, String> {
	
	Page<UnitEntity> findByOrderByUnitAsc(Pageable pageable);
	
	UnitEntity findByUnit(String Unit);
	
}
