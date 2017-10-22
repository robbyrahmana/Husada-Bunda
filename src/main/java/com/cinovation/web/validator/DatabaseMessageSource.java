package com.cinovation.web.validator;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;

import com.cinovation.web.entity.ConfigurationEntity;
import com.cinovation.web.repository.ConfigurationRepository;

public class DatabaseMessageSource extends AbstractMessageSource{
	
	@Autowired
	ConfigurationRepository configurationRepository;
	
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		String[] splitcode = code.split(Pattern.quote("."));
		ConfigurationEntity configurationEntity = configurationRepository.findByCodeAndLocale("validation.error." + splitcode[0], locale);
		MessageFormat format;
		
		if(configurationEntity != null) {
			format = new MessageFormat(configurationEntity.getText1() + "," + configurationEntity.getText2(), configurationEntity.getLocale());
		} else {
			format = new MessageFormat(code, locale);
		}
		
		return format;
	}
	
}
