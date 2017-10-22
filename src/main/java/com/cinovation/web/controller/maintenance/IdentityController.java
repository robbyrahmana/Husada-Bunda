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

import com.cinovation.web.dto.maintenance.IdentityDto;
import com.cinovation.web.entity.maintenance.IdentityEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.IdentityService;

@RestController
@RequestMapping(value = "/maintenance/identity")
public class IdentityController extends DataConverter {
	
	@Inject
	IdentityService identityService;
	
	public IdentityController() {
		server = IdentityEntity.class;
		view = IdentityDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<IdentityDto> getTable(String filter1, Pageable pageable) {
		
        Page<IdentityEntity> page = identityService.getIdentityTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<IdentityDto> getList() {
		
        List<IdentityEntity> page = identityService.getIdentityList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public IdentityDto getListById(@PathVariable("id") String ID) {
		
        IdentityEntity page = identityService.getIdentityListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public IdentityDto save(@Validated @RequestBody IdentityDto data) throws Exception {
		
        IdentityEntity page = identityService.saveIdentity(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public IdentityDto update(@Validated @RequestBody IdentityDto data) throws Exception {
		
        IdentityEntity page = identityService.updateIdentity(serverData(data));
        
        return viewData(page);
    }
}
