package com.ejada.validations.core;

import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.result.EnglishLanguageResult;
import com.ejada.validations.result.ValidationResult;

public class EnglishLanguageValidator implements Validator{
	
	EnglishValidationConfig config ; 
	
	public EnglishLanguageValidator() {
		super();
	}

	public EnglishLanguageValidator(EnglishValidationConfig config) {
		super();
		this.config = config;
	}
	
	@Override
	public ValidationResult validate(String field, String fieldName){
		return new EnglishLanguageResult(field.matches("^[a-zA-Z ]+$"), fieldName);
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (EnglishValidationConfig) config;
	}

}
