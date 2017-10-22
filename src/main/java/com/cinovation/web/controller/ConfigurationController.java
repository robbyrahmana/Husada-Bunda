package com.cinovation.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.ConfigurationDto;
import com.cinovation.web.entity.ConfigurationEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.ConfigurationService;

@RestController
@RequestMapping(value = "/configuration")
public class ConfigurationController extends DataConverter {
	
	@Inject
	ConfigurationService configurationService;
	
	public ConfigurationController() {
		server = ConfigurationEntity.class;
		view = ConfigurationDto.class;
	}
	
	@RequestMapping(value = "/page/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<ConfigurationDto> getTable(@PathVariable("code") String code) {
		
		List<ConfigurationEntity> page = configurationService.getConfigByCode(code);
    	
    	return viewDataList(page);
    }	
}
