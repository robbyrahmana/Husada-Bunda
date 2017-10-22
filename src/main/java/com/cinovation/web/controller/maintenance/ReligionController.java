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

import com.cinovation.web.dto.maintenance.ReligionDto;
import com.cinovation.web.entity.maintenance.ReligionEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.ReligionService;

@RestController
@RequestMapping(value = "/maintenance/religion")
public class ReligionController extends DataConverter {
	
	@Inject
	ReligionService religionService;
	
	public ReligionController() {
		server = ReligionEntity.class;
		view = ReligionDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<ReligionDto> getTable(String filter1, Pageable pageable) {
		
        Page<ReligionEntity> page = religionService.getReligionTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<ReligionDto> getList() {
		
        List<ReligionEntity> page = religionService.getReligionList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public ReligionDto getListById(@PathVariable("id") String ID) {
		
        ReligionEntity page = religionService.getReligionListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public ReligionDto save(@Validated @RequestBody ReligionDto data) throws Exception {
		
        ReligionEntity page = religionService.saveReligion(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public ReligionDto update(@Validated @RequestBody ReligionDto data) throws Exception {
		
        ReligionEntity page = religionService.updateReligion(serverData(data));
        
        return viewData(page);
    }
}
