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

import com.cinovation.web.dto.maintenance.RelationshipDto;
import com.cinovation.web.entity.maintenance.RelationshipEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.RelationshipService;

@RestController
@RequestMapping(value = "/maintenance/relationship")
public class RelationshipController extends DataConverter {

	@Inject
	RelationshipService relationshipService;
	
	public RelationshipController() {
		server = RelationshipEntity.class;
		view = RelationshipDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<RelationshipDto> getTable(String filter1, Pageable pageable) {
		
        Page<RelationshipEntity> page = relationshipService.getRelationshipTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<RelationshipDto> getList() {
		
        List<RelationshipEntity> page = relationshipService.getRelationshipList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RelationshipDto getListById(@PathVariable("id") String ID) {
		
        RelationshipEntity page = relationshipService.getRelationshipListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RelationshipDto save(@Validated @RequestBody RelationshipDto data) throws Exception {
		
        RelationshipEntity page = relationshipService.saveRelationship(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public RelationshipDto update(@Validated @RequestBody RelationshipDto data) throws Exception {
		
        RelationshipEntity page = relationshipService.updateRelationship(serverData(data));
        
        return viewData(page);
    }
}
