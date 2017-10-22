package com.cinovation.web.controller.room;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.room.RoomCategoryDto;
import com.cinovation.web.entity.room.RoomCategoryEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.room.RoomCategoryService;

@RestController
@RequestMapping(value = "/room/roomcategory")
public class RoomCategoryController extends DataConverter {

	@Inject
	RoomCategoryService roomCategoryService;
	
	public RoomCategoryController() {
		server = RoomCategoryEntity.class;
		view = RoomCategoryDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<RoomCategoryDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<RoomCategoryEntity> page = roomCategoryService.getRoomCategoryTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RoomCategoryDto> getList() {
		
        List<RoomCategoryEntity> page = roomCategoryService.getRoomCategoryList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomCategoryDto getListById(@PathVariable("id") String ID) {
		
        RoomCategoryEntity page = roomCategoryService.getRoomCategoryListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomCategoryDto save(@Validated @RequestBody RoomCategoryDto data) throws Exception {
		
        RoomCategoryEntity page = roomCategoryService.saveRoomCategory(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomCategoryDto update(@Validated @RequestBody RoomCategoryDto data) throws Exception {
		
        RoomCategoryEntity page = roomCategoryService.updateRoomCategory(serverData(data));
        
        return viewData(page);
    }
}
