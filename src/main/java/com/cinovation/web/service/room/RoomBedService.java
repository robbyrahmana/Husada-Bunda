package com.cinovation.web.service.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.vo.CountVO;

public interface RoomBedService {
	
	Page<RoomBedEntity> getRoomBedTable(String filter1, Pageable pageable);
	
	List<RoomBedEntity> getRoomBedList();
	
	RoomBedEntity getRoomBedListById(String ID);
	
	RoomBedEntity saveRoomBed(RoomBedEntity dataContainer) throws Exception;
	
	RoomBedEntity updateRoomBed(RoomBedEntity dataContainer) throws Exception;
	
	RoomBedEntity deleteRoomBedById(String ID) throws Exception;
	
	List<RoomBedEntity> getRoomBedListByDetailId(String ID);
	
	void updateRoomBedAvailableById(String ID);
	
	List<CountVO> findCountRoomByGroupByDetailId();
	
}
