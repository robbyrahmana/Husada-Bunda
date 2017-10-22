package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.TitleEntity;

public interface TitleRepository extends JpaRepository<TitleEntity, String> {
	
	Page<TitleEntity> findByOrderByTitleAsc(Pageable pageable);
	
	TitleEntity findByTitle(String title);
	
}
