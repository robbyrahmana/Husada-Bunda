package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.RelationshipEntity;

public interface RelationshipRepository extends JpaRepository<RelationshipEntity, String> {
	
	Page<RelationshipEntity> findByOrderByRelationshipAsc(Pageable pageable);
	
	RelationshipEntity findByRelationship(String relationship);
	
}
