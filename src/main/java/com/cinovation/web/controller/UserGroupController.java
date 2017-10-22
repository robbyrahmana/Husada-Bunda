package com.cinovation.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.UserGroupDto;
import com.cinovation.web.entity.UserGroupEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.UserGroupService;

@RestController
@RequestMapping(value = "/user/usergroup")
public class UserGroupController extends DataConverter {

	@Inject
	UserGroupService userGroupService;

	public UserGroupController() {
		server = UserGroupEntity.class;
		view = UserGroupDto.class;
	}

	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<UserGroupDto> getList() {
	      
		List<UserGroupEntity> page = userGroupService.findAll();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserGroupDto getListById(@PathVariable("id") String id) {

		UserGroupEntity page = userGroupService.findById(id);

		return viewData(page);
	}
}
