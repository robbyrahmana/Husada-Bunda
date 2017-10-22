package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.RhesusEntity;

public interface RhesusRepository extends JpaRepository<RhesusEntity, String> {
	
	Page<RhesusEntity> findByOrderByRhesusAsc(Pageable pageable);
	
	RhesusEntity findByRhesus(String rhesus);
	
}
