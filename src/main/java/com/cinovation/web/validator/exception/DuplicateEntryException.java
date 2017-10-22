package com.cinovation.web.validator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cinovation.web.constant.ApplicationConstants;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate entry")
public class DuplicateEntryException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DuplicateEntryException(){
		super(ApplicationConstants.VALIDATION_RECORD_CUPLICATE_RECORD);
	}

}
