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

import com.cinovation.web.dto.maintenance.RhesusDto;
import com.cinovation.web.entity.maintenance.RhesusEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.RhesusService;

@RestController
@RequestMapping(value = "/maintenance/rhesus")
public class RhesusController extends DataConverter {

	@Inject
	RhesusService rhesusService;

	public RhesusController() {
		server = RhesusEntity.class;
		view = RhesusDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<RhesusDto> getTable(String filter1, Pageable pageable) {
		
        Page<RhesusEntity> page = rhesusService.getRhesusTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RhesusDto> getList() {
		
        List<RhesusEntity> page = rhesusService.getRhesusList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RhesusDto getListById(@PathVariable("id") String ID) {
		
        RhesusEntity page = rhesusService.getRhesusListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RhesusDto save(@Validated @RequestBody RhesusDto data) throws Exception {
		
        RhesusEntity page = rhesusService.saveRhesus(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RhesusDto update(@Validated @RequestBody RhesusDto data) throws Exception {
		
        RhesusEntity page = rhesusService.updateRhesus(serverData(data));
        
        return viewData(page);
    }
}
