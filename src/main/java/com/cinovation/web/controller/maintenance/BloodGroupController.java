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

import com.cinovation.web.dto.maintenance.BloodGroupDto;
import com.cinovation.web.entity.maintenance.BloodGroupEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.BloodGroupService;

@RestController
@RequestMapping(value = "/maintenance/bloodgroup")
public class BloodGroupController extends DataConverter {

	@Inject
	BloodGroupService bloodGroupService;
	
	public BloodGroupController() {
		server = BloodGroupEntity.class;
		view = BloodGroupDto.class;
	}
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<BloodGroupDto> getTable(Pageable pageable) {
		
		Page<BloodGroupEntity> page = bloodGroupService.getBloodGroupTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<BloodGroupDto> getList() {
		
        List<BloodGroupEntity> page = bloodGroupService.getBloodGroupList();
    	
        return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public BloodGroupDto getListById(@PathVariable("id") String ID) {
		
        BloodGroupEntity page = bloodGroupService.getBloodGroupListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public BloodGroupDto save(@Validated @RequestBody BloodGroupDto data) throws Exception {
		
        BloodGroupEntity page = bloodGroupService.saveBloodGroup(serverData(data));
        
        return viewData(page);
        
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public BloodGroupDto update(@Validated @RequestBody BloodGroupDto data) throws Exception {
		
        BloodGroupEntity page = bloodGroupService.updateBloodGroup(serverData(data));
        
        return viewData(page);
        
    }
}
