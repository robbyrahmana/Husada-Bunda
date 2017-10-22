package com.cinovation.web.repository.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.room.RoomDetailEntity;

public interface RoomDetailRepository extends JpaRepository<RoomDetailEntity, String> {
	
	Page<RoomDetailEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	RoomDetailEntity findByCdOrName(String cd, String name);
	
	List<RoomDetailEntity> findByRoomCategoryEntityIdContaining(String ID);
	
}
