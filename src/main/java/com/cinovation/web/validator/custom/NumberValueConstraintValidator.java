package com.cinovation.web.validator.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValueConstraintValidator implements ConstraintValidator<NumberValue, String>{
	
	@Override
	public void initialize(NumberValue numberValue) {}
	
	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext ctx) {
		if(phoneField == null) {
			return false;
		}
		return phoneField.matches("[0-9]*");
	}
}
