package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.RelationshipEntity;

public interface RelationshipService {
	Page<RelationshipEntity> getRelationshipTable(Pageable pageable);
	
	List<RelationshipEntity> getRelationshipList();
	
	RelationshipEntity getRelationshipListById(String ID);
	
	RelationshipEntity saveRelationship(RelationshipEntity dataContainer) throws Exception;
	
	RelationshipEntity updateRelationship(RelationshipEntity dataContainer) throws Exception;
	
	RelationshipEntity deleteRelationshipById(String ID) throws Exception;
}
