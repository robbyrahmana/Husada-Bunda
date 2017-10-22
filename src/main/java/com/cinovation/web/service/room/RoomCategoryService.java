package com.cinovation.web.service.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.room.RoomCategoryEntity;

public interface RoomCategoryService {
	
	Page<RoomCategoryEntity> getRoomCategoryTable(String filter1, String filter2, Pageable pageable);
	
	List<RoomCategoryEntity> getRoomCategoryList();
	
	RoomCategoryEntity getRoomCategoryListById(String ID);
	
	RoomCategoryEntity saveRoomCategory(RoomCategoryEntity dataContainer) throws Exception;
	
	RoomCategoryEntity updateRoomCategory(RoomCategoryEntity dataContainer) throws Exception;
	
	RoomCategoryEntity deleteRoomCategoryById(String ID) throws Exception;
	
}
