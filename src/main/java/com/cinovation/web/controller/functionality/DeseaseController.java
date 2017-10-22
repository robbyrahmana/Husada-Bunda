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

import com.cinovation.web.dto.functionality.DeseaseDto;
import com.cinovation.web.entity.functionality.DeseaseEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.functionality.DeseaseService;

@RestController
@RequestMapping(value = "/functionality/desease")
public class DeseaseController extends DataConverter {

	@Inject
	DeseaseService deseaseService;
	
	public DeseaseController() {
		server = DeseaseEntity.class;
		view = DeseaseDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<DeseaseDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<DeseaseEntity> page = deseaseService.getDeseaseTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<DeseaseDto> getList() {
		
        List<DeseaseEntity> page = deseaseService.getDeseaseList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public DeseaseDto getListById(@PathVariable("id") String ID) {
		
        DeseaseEntity page = deseaseService.getDeseaseListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public DeseaseDto save(@Validated @RequestBody DeseaseDto data) throws Exception {
		
        DeseaseEntity page = deseaseService.saveDesease(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public DeseaseDto update(@Validated @RequestBody DeseaseDto data) throws Exception {
		
        DeseaseEntity page = deseaseService.updateDesease(serverData(data));
        
        return viewData(page);
    }
}
