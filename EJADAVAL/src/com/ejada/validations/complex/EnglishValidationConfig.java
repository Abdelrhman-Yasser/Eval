package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class EnglishValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public EnglishValidationConfig() {
		super();
		this.type = ValidationType.EnglishLang;
	}

	@Override
	public ValidationType getType() {
		return type;
	}

	@Override
	public ValidationParam<?> getParam(ParamType type) {
		return null ;
	}

}
