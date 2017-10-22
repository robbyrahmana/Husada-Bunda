package com.cinovation.web.service;

import java.util.List;

import com.cinovation.web.entity.ConfigurationEntity;

public interface ConfigurationService {
	
	List<ConfigurationEntity> getConfigByCode(String code);
	
}
