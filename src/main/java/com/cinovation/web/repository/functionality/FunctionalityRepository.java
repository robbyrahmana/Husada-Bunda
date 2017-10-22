package com.cinovation.web.repository.functionality;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.functionality.FunctionalityEntity;

public interface FunctionalityRepository extends JpaRepository<FunctionalityEntity, String> {
	
	Page<FunctionalityEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	FunctionalityEntity findByCdOrName(String cd, String name);
	
	FunctionalityEntity findByCd(String cd);
	
	List<FunctionalityEntity> findByPositionEntityId(String ID);
}
