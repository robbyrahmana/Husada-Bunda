package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.ReligionEntity;

public interface ReligionRepository extends JpaRepository<ReligionEntity, String> {
	
	Page<ReligionEntity> findByOrderByReligionAsc(Pageable pageable);
	
	ReligionEntity findByReligion(String title);
	
}
