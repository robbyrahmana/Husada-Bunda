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

import com.cinovation.web.dto.maintenance.WorkDto;
import com.cinovation.web.entity.maintenance.WorkEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.WorkService;

@RestController
@RequestMapping(value = "/maintenance/work")
public class WorkController extends DataConverter {

	@Inject
	WorkService workService;

	public WorkController() {
		server = WorkEntity.class;
		view = WorkDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<WorkDto> getTable(String filter1, Pageable pageable) {
		
        Page<WorkEntity> page = workService.getWorkTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<WorkDto> getList() {
		
        List<WorkEntity> page = workService.getWorkList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public WorkDto getListById(@PathVariable("id") String ID) {
		
        WorkEntity page = workService.getWorkListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public WorkDto save(@Validated @RequestBody WorkDto data) throws Exception {
		
        WorkEntity page = workService.saveWork(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public WorkDto update(@Validated @RequestBody WorkDto data) throws Exception {
		
        WorkEntity page = workService.updateWork(serverData(data));
        
        return viewData(page);
    }
}
