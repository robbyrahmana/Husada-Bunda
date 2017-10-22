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

import com.cinovation.web.dto.room.RoomBedDto;
import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.room.RoomBedService;
import com.cinovation.web.vo.CountVO;

@RestController
@RequestMapping(value = "/room/roombed")
public class RoomBedController extends DataConverter {

	@Inject
	RoomBedService roomBedService;
	
	public RoomBedController() {
		server = RoomBedEntity.class;
		view = RoomBedDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<RoomBedDto> getTable(String filter1, Pageable pageable) {
		
        Page<RoomBedEntity> page = roomBedService.getRoomBedTable(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RoomBedDto> getList() {
		
        List<RoomBedEntity> page = roomBedService.getRoomBedList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomBedDto getListById(@PathVariable("id") String ID) {
		
        RoomBedEntity page = roomBedService.getRoomBedListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomBedDto save(@Validated @RequestBody RoomBedDto data) throws Exception {
		
        RoomBedEntity page = roomBedService.saveRoomBed(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomBedDto update(@Validated @RequestBody RoomBedDto data) throws Exception {
		
        RoomBedEntity page = roomBedService.updateRoomBed(serverData(data));
        
        return viewData(page);
    }
	
	// Additional
	@RequestMapping(value = "/getListByDetailIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RoomBedDto> getListByCategoryId(@PathVariable("id") String ID) {
		
        List<RoomBedEntity> page = roomBedService.getRoomBedListByDetailId(ID);
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/countRoomByDetailIdAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<CountVO> countRoomByDetailId() {
		
        List<CountVO> data = roomBedService.findCountRoomByGroupByDetailId();
        
        return data;
    }
}
