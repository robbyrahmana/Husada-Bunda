package com.cinovation.web.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.UserDto;
import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.UserService;

@RestController
@RequestMapping(value = "/user/user")
public class UserController extends DataConverter {

	@Inject
	UserService userService;

	public UserController() {
		server = UserEntity.class;
		view = UserDto.class;
	}
	
	@RequestMapping(value = "/getListByCdAction/{cd}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDto getListById(@PathVariable("cd") String cd) {

		UserEntity page = userService.getUserListByCd(cd);

		return viewData(page);
	}
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public UserDto save(@Validated @RequestBody UserDto data) throws Exception {
        
        UserEntity page = userService.saveUser(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public UserDto update(@Validated @RequestBody UserDto data) throws Exception {
        
        UserEntity page = userService.updateUser(serverData(data));
        
        return viewData(page);
    }
}
