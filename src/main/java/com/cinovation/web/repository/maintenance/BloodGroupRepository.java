package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.BloodGroupEntity;

public interface BloodGroupRepository extends JpaRepository<BloodGroupEntity, String> {
	
	Page<BloodGroupEntity> findByOrderByBloodgroupAsc(Pageable pageable);
	
	BloodGroupEntity findByBloodgroup(String title);

	
}