package com.cinovation.web.service.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.room.RoomDetailEntity;

public interface RoomDetailService {
	
	Page<RoomDetailEntity> getRoomDetailTable(String filter1, String filter2, Pageable pageable);
	
	List<RoomDetailEntity> getRoomDetailList();
	
	RoomDetailEntity getRoomDetailListById(String ID);
	
	RoomDetailEntity saveRoomDetail(RoomDetailEntity dataContainer) throws Exception;
	
	RoomDetailEntity updateRoomDetail(RoomDetailEntity dataContainer) throws Exception;
	
	RoomDetailEntity deleteRoomDetailById(String ID) throws Exception;
	
	List<RoomDetailEntity> getRoomDetailListByCategoryId(String ID);
	
}
