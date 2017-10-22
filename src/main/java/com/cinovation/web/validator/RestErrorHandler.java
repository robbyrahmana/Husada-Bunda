package com.cinovation.web.validator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cinovation.web.entity.ConfigurationEntity;
import com.cinovation.web.repository.ConfigurationRepository;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@ControllerAdvice
public class RestErrorHandler {
	private MessageSource messageSource;
	
	@Autowired
	ConfigurationRepository configurationRepository;
	
    @Autowired
    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return processFieldErrors(fieldErrors);
    }
    
    /* Start Add New */
    @ExceptionHandler(DuplicateEntryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
	public Map<String, Object> handleDuplicateEntryException(DuplicateEntryException ex){
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	ConfigurationEntity configurationEntity = configurationRepository.findByCodeAndLocale(ex.getMessage(), Locale.US);
    	map.put("error", configurationEntity.getText1() + "," + configurationEntity.getText2());
    	return map;
    	
	}
    
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
	public Map<String, Object> handleRecordNotFoundException(RecordNotFoundException ex){
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	ConfigurationEntity configurationEntity = configurationRepository.findByCodeAndLocale(ex.getMessage(), Locale.US);
    	map.put("error", configurationEntity.getText1() + "," + configurationEntity.getText2());
    	return map;
    	
	}
    
    /* End Add New */
 
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }
 
        return dto;
    }
 
    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
 
        //If the message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        	//localizedErrorMessage = databaseMessageSource.getMessage(fieldErrorCodes[0], currentLocale);
        }
        return localizedErrorMessage;
    }
}
