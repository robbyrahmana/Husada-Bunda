package com.cinovation.web.controller.maintenance;

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

import com.cinovation.web.dto.maintenance.UnitDto;
import com.cinovation.web.entity.maintenance.UnitEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.UnitService;

@RestController
@RequestMapping(value = "/maintenance/unit")
public class UnitController extends DataConverter {
	
	@Inject
	UnitService unitService;

	public UnitController() {
		server = UnitEntity.class;
		view = UnitDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<UnitDto> getTable(String filter1, Pageable pageable) {
		
        Page<UnitEntity> page = unitService.getUnitTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<UnitDto> getList() {
		
        List<UnitEntity> page = unitService.getUnitList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public UnitDto getListById(@PathVariable("id") String ID) {
		
        UnitEntity page = unitService.getUnitListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public UnitDto save(@Validated @RequestBody UnitDto data) throws Exception {
		
        UnitEntity page = unitService.saveUnit(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public UnitDto update(@Validated @RequestBody UnitDto data) throws Exception {
		
        UnitEntity page = unitService.updateUnit(serverData(data));
        
        return viewData(page);
    }
}
