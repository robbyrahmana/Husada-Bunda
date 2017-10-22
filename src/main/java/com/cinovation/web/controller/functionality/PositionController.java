package com.cinovation.web.controller.functionality;

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

import com.cinovation.web.dto.functionality.PositionDto;
import com.cinovation.web.entity.functionality.PositionEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.functionality.PositionService;

@RestController
@RequestMapping(value = "/functionality/position")
public class PositionController extends DataConverter {
	
	@Inject
	PositionService positionService;
	
	public PositionController() {
		server = PositionEntity.class;
		view = PositionDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PositionDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<PositionEntity> page = positionService.getPositionTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PositionDto> getList() {
		
        List<PositionEntity> page = positionService.getPositionList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PositionDto getListById(@PathVariable("id") String ID) {
		
        PositionEntity page = positionService.getPositionListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PositionDto save(@Validated @RequestBody PositionDto data) throws Exception {
		
        PositionEntity page = positionService.savePosition(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PositionDto update(@Validated @RequestBody PositionDto data) throws Exception {
        
		PositionEntity page = positionService.updatePosition(serverData(data));
        
		return viewData(page);
    }
}
