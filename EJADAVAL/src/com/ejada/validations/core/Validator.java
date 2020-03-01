package com.ejada.validations.core;

import com.ejada.validations.result.ValidationResult;

public interface Validator {

	ValidationResult validate(String field);

	public <T> void setConfig(T config);
	
}
