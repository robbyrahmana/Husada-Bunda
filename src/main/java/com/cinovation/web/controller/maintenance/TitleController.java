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

import com.cinovation.web.dto.maintenance.TitleDto;
import com.cinovation.web.entity.maintenance.TitleEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.TitleService;

@RestController
@RequestMapping(value = "/maintenance/title")
public class TitleController extends DataConverter {
	
	@Inject
	TitleService titleService;
	
	public TitleController() {
		server = TitleEntity.class;
		view = TitleDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<TitleDto> getTable(String filter1, Pageable pageable) {
		
        Page<TitleEntity> page = titleService.getTitleTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TitleDto> getList() {
		
        List<TitleEntity> page = titleService.getTitleList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TitleDto getListById(@PathVariable("id") String ID) {
		
        TitleEntity page = titleService.getTitleListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TitleDto save(@Validated @RequestBody TitleDto data) throws Exception {
		
        TitleEntity page = titleService.saveTitle(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TitleDto update(@Validated @RequestBody TitleDto data) throws Exception {
		
        TitleEntity page = titleService.updateTitle(serverData(data));
        
        return viewData(page);
    }
}
