package com.cinovation.web.validator;

import java.util.ArrayList;
import java.util.List;

import com.cinovation.web.vo.FieldErrorVO;

public class ValidationErrorDTO {
	private List<FieldErrorVO> fieldErrors = new ArrayList<>();

	public ValidationErrorDTO() {

	}

	public void addFieldError(String path, String text) {
		FieldErrorVO error = new FieldErrorVO(path, text);
		fieldErrors.add(error);
	}

	public List<FieldErrorVO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorVO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
