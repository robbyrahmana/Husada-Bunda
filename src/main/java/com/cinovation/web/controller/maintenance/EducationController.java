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

import com.cinovation.web.dto.maintenance.EducationDto;
import com.cinovation.web.entity.maintenance.EducationEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.EducationService;

@RestController
@RequestMapping(value = "/maintenance/education")
public class EducationController extends DataConverter {

	@Inject
	EducationService educationService;

	public EducationController() {
		server = EducationEntity.class;
		view = EducationDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<EducationDto> getTable(String filter1, Pageable pageable) {
		
        Page<EducationEntity> page = educationService.getEducationTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<EducationDto> getList() {
		
        List<EducationEntity> page = educationService.getEducationList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public EducationDto getListById(@PathVariable("id") String ID) {
		
        EducationEntity page = educationService.getEducationListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public EducationDto save(@Validated @RequestBody EducationDto data) throws Exception {
		
        EducationEntity page = educationService.saveEducation(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public EducationDto update(@Validated @RequestBody EducationDto data) throws Exception {
		
        EducationEntity page = educationService.updateEducation(serverData(data));
        
        return viewData(page);
    }
}
