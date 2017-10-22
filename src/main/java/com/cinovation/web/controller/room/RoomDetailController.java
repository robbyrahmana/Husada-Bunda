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

import com.cinovation.web.dto.room.RoomDetailDto;
import com.cinovation.web.entity.room.RoomDetailEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.room.RoomDetailService;

@RestController
@RequestMapping(value = "/room/roomdetail")
public class RoomDetailController extends DataConverter {

	@Inject
	RoomDetailService roomDetailService;

	public RoomDetailController() {
		server = RoomDetailEntity.class;
		view = RoomDetailDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<RoomDetailDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<RoomDetailEntity> page = roomDetailService.getRoomDetailTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RoomDetailDto> getList() {
		
        List<RoomDetailEntity> page = roomDetailService.getRoomDetailList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomDetailDto getListById(@PathVariable("id") String ID) {
		
        RoomDetailEntity page = roomDetailService.getRoomDetailListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomDetailDto save(@Validated @RequestBody RoomDetailDto data) throws Exception {
		
        RoomDetailEntity page = roomDetailService.saveRoomDetail(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RoomDetailDto update(@Validated @RequestBody RoomDetailDto data) throws Exception {
		
        RoomDetailEntity page = roomDetailService.updateRoomDetail(serverData(data));
        
        return viewData(page);
    }
	
	// Additional
	@RequestMapping(value = "/getListByCategoryIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RoomDetailDto> getListByCategoryId(@PathVariable("id") String ID) {
		
        List<RoomDetailEntity> page = roomDetailService.getRoomDetailListByCategoryId(ID);
    	
    	return viewDataList(page);
    }
}
