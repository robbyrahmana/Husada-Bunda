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

import com.cinovation.web.dto.functionality.FunctionalityDto;
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.functionality.FunctionalityService;

@RestController
@RequestMapping(value = "/functionality/functionality")
public class FunctionalityController extends DataConverter {
	
	@Inject
	FunctionalityService functionalityService;
	
	public FunctionalityController() {
		server = FunctionalityEntity.class;
		view = FunctionalityDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<FunctionalityDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<FunctionalityEntity> page = functionalityService.getFunctionalityTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<FunctionalityDto> getList() {
		
        List<FunctionalityEntity> page = functionalityService.getFunctionalityList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public FunctionalityDto getListById(@PathVariable("id") String ID) {
		
        FunctionalityEntity page = functionalityService.getFunctionalityListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/getListByCdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public FunctionalityDto getListByCd(@PathVariable("id") String ID) {
		
        FunctionalityEntity page = functionalityService.getFunctionalityListByCd(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public FunctionalityDto save(@Validated @RequestBody FunctionalityDto data) throws Exception {
		
        FunctionalityEntity page = functionalityService.saveFunctionality(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public FunctionalityDto update(@Validated @RequestBody FunctionalityDto data) throws Exception {
        
		FunctionalityEntity page = functionalityService.updateFunctionality(serverData(data));
        
		return viewData(page);
    }
	
	// Additional
	@RequestMapping(value = "/getListByPosition/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<FunctionalityDto> getListByPosition(@PathVariable("id") String ID) {
        
		List<FunctionalityEntity> page = functionalityService.getPositionEntityId(ID);
    	
    	return viewDataList(page);
    }
}
