package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.TribeEntity;

public interface TribeRepository extends JpaRepository<TribeEntity, String> {
	
	Page<TribeEntity> findByOrderByTribeAsc(Pageable pageable);
	
	TribeEntity findByTribe(String title);
	
}
