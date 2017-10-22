package com.cinovation.web.repository.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.vo.CountVO;

public interface RoomBedRepository extends JpaRepository<RoomBedEntity, String> {
	
	Page<RoomBedEntity> findByCdContainingOrderByCdAsc(String filter1, Pageable pageable);
	
	RoomBedEntity findByCd(String cd);
	
	List<RoomBedEntity> findByRoomDetailEntityIdAndIsAvailable(String ID, int available);
	
	@Query("select new com.cinovation.web.vo.CountVO(det.id, count(bed)) from RoomBedEntity bed INNER JOIN bed.roomDetailEntity det group by bed.roomDetailEntity")
	List<CountVO> findCountRoomByGroupByDetailId();
}
