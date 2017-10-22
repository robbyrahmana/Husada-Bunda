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

import com.cinovation.web.dto.functionality.SMFDto;
import com.cinovation.web.entity.functionality.SMFEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.functionality.SMFService;

@RestController
@RequestMapping(value = "/functionality/smf")
public class SMFController extends DataConverter {

	@Inject
	SMFService sMFService;
	
	public SMFController() {
		server = SMFEntity.class;
		view = SMFDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<SMFDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<SMFEntity> page = sMFService.getSMFTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<SMFDto> getList() {
		
        List<SMFEntity> page = sMFService.getSMFList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public SMFDto getListById(@PathVariable("id") String ID) {
		
        SMFEntity page = sMFService.getSMFListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public SMFDto save(@Validated @RequestBody SMFDto data) throws Exception {
		
        SMFEntity page = sMFService.saveSMF(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public SMFDto update(@Validated @RequestBody SMFDto data) throws Exception {
		
        SMFEntity page = sMFService.updateSMF(serverData(data));
        
        return viewData(page);
    }
}
