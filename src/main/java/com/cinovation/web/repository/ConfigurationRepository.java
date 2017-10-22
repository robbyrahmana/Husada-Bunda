package com.cinovation.web.repository;

import java.util.List;
import java.util.Locale;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.ConfigurationEntity;

@Cacheable("CacheConfig")
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, String> {
	
	ConfigurationEntity findByCodeAndLocale(String code, Locale locale);
	
	List<ConfigurationEntity> findByCodeContaining(String code);
	
}
