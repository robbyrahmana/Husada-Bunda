package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.EducationEntity;

public interface EducationRepository extends JpaRepository<EducationEntity, String> {
	
	Page<EducationEntity> findByOrderByEducationAsc(Pageable pageable);
	
	EducationEntity findByEducation(String education);
	
}
