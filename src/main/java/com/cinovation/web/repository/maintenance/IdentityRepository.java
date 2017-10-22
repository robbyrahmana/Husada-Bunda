package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.IdentityEntity;

public interface IdentityRepository extends JpaRepository<IdentityEntity, String> {
	
	Page<IdentityEntity> findByOrderByIdentityAsc(Pageable pageable);
	
	IdentityEntity findByIdentity(String title);
	
}
