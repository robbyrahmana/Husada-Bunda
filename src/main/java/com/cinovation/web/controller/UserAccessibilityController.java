package com.cinovation.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.UserAccessibilityDto;
import com.cinovation.web.entity.UserAccessibilityEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.UserAccessibilityService;

@RestController
@RequestMapping(value = "/user/menu")
public class UserAccessibilityController extends DataConverter{

	@Inject
	UserAccessibilityService userAccessibilityService;

	public UserAccessibilityController() {
		server = UserAccessibilityEntity.class;
		view = UserAccessibilityDto.class;
	}

	@RequestMapping(value = "/getMenuByUserGroupIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserAccessibilityDto> getTable(@PathVariable("id") String id) {

		List<UserAccessibilityEntity> page = userAccessibilityService.findByUserGroupId(id);

		return viewDataList(page);
	}
}
