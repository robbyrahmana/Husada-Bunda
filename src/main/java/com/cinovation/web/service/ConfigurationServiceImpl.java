package com.cinovation.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.ConfigurationEntity;
import com.cinovation.web.repository.ConfigurationRepository;

@Service
@RepositoryEventHandler
public class ConfigurationServiceImpl implements ConfigurationService{
	
	private static final Logger logger = Logger.getLogger(ConfigurationServiceImpl.class);
	
	@Autowired
	ConfigurationRepository configurationRepository;
	
	@Override
	public List<ConfigurationEntity> getConfigByCode(String code) {
		logger.info("");
		return configurationRepository.findByCodeContaining(code);
	}
	
}
