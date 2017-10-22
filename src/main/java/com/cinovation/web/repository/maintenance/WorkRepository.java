package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.WorkEntity;

public interface WorkRepository extends JpaRepository<WorkEntity, String> {
	
	Page<WorkEntity> findByOrderByWorkAsc(Pageable pageable);
	
	WorkEntity findByWork(String work);

}
