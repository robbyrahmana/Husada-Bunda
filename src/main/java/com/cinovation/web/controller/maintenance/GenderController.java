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

import com.cinovation.web.dto.maintenance.GenderDto;
import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.GenderService;

@RestController
@RequestMapping(value = "/maintenance/gender")
public class GenderController extends DataConverter {
	
	@Inject
	GenderService genderService;
	
	public GenderController() {
		server = GenderEntity.class;
		view = GenderDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<GenderDto> getTable(String filter1, Pageable pageable) {
		
        Page<GenderEntity> page = genderService.getGenderTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<GenderDto> getList() {
		
        List<GenderEntity> page = genderService.getGenderList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public GenderDto getListById(@PathVariable("id") String ID) {
		
        GenderEntity page = genderService.getGenderListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public GenderDto save(@Validated @RequestBody GenderDto data) throws Exception {
		
        GenderEntity page = genderService.saveGender(serverData(data));
        
        return viewData(page);  
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public GenderDto update(@Validated @RequestBody GenderDto data) throws Exception {
		
        GenderEntity page = genderService.updateGender(serverData(data));
        
        return viewData(page);  
    }
}
