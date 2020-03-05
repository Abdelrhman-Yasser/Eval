package com.ejada.validations.core;

import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.EnglishLanguageResult;
import com.ejada.validations.result.ValidationResult;

public class EnglishLanguageValidator implements Validator{
	
	private EnglishValidationConfig config ; 
	
	public EnglishLanguageValidator() {
		super();
	}

	public EnglishLanguageValidator(EnglishValidationConfig config) {
		super();
		this.config = config;
	}
	
	@Override
	public ValidationResult validate(String field, String fieldName){
		return new EnglishLanguageResult(field.matches("^[a-zA-Z ]+$"), fieldName, (Language)config.getParam(ParamType.Language).getValue());
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (EnglishValidationConfig) config;
	}

}
