package com.cinovation.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, String> {
	
	StatusEntity findByCd(String cd);
	
}
