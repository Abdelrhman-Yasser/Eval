package com.ejada.validations.core;

import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.result.FloatResult;
import com.ejada.validations.result.ValidationResult;

public class FloatValidator implements Validator {

	FloatValidationConfig config ;
	
	public FloatValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FloatValidator(FloatValidationConfig config) {
		super();
		this.config = config;
	}

	@Override
	public ValidationResult validate(String field, String fieldName) {
		return new FloatResult(field.matches("^[-+]?[0-9]*\\.?[0-9]+$"),fieldName);
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (FloatValidationConfig) config;
	}

}
