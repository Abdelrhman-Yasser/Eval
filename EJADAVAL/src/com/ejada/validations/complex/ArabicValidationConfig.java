package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class ArabicValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public ArabicValidationConfig() {
		super();
		this.type = ValidationType.ArabicLang;
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
