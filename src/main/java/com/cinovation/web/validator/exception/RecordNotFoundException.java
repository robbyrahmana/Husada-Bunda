package com.cinovation.web.validator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cinovation.web.constant.ApplicationConstants;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Record not found")
public class RecordNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(){
		super(ApplicationConstants.VALIDATION_RECORD_NOT_FOUND);
	}
	
}
