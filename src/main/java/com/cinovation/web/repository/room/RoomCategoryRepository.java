package com.cinovation.web.repository.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.room.RoomCategoryEntity;


public interface RoomCategoryRepository extends JpaRepository<RoomCategoryEntity, String> {
	
	Page<RoomCategoryEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	RoomCategoryEntity findByCdOrName(String cd, String name);
	
}
