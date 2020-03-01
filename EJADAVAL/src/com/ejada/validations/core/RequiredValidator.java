package com.ejada.validations.core;

import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

public class RequiredValidator implements Validator {

	RequiredValidationConfig config;
	
	public RequiredValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequiredValidator(RequiredValidationConfig config) {
		super();
		this.config = config ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ValidationResult validate(String field) {
		boolean valid = true ;
		valid &= field != "null" ;
		valid &= field != "Null" ;
		valid &= field != "{}" ;
		valid &= !field.isBlank();
		return new RequiredResult(valid);
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (RequiredValidationConfig) config ;
	}

}
