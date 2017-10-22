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

import com.cinovation.web.dto.maintenance.TribeDto;
import com.cinovation.web.entity.maintenance.TribeEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.TribeService;

@RestController
@RequestMapping(value = "/maintenance/tribe")
public class TribeController extends DataConverter {

	@Inject
	TribeService tribeService;

	public TribeController() {
		server = TribeEntity.class;
		view = TribeDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<TribeDto> getTable(String filter1, Pageable pageable) {
		
        Page<TribeEntity> page = tribeService.getTribeTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TribeDto> getList() {
		
        List<TribeEntity> page = tribeService.getTribeList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TribeDto getListById(@PathVariable("id") String ID) {
		
        TribeEntity page = tribeService.getTribeListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TribeDto save(@Validated @RequestBody TribeDto data) throws Exception {
		
        TribeEntity page = tribeService.saveTribe(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TribeDto update(@Validated @RequestBody TribeDto data) throws Exception {
		
        TribeEntity page = tribeService.updateTribe(serverData(data));
        
        return viewData(page);
    }
}
