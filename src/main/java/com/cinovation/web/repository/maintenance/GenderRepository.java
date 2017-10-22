package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, String> {
	
	Page<GenderEntity> findByOrderByGenderAsc(Pageable pageable);
	
	GenderEntity findByGender(String title);
	
}
