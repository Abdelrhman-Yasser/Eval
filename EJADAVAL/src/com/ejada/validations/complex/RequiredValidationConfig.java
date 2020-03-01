package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class RequiredValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public RequiredValidationConfig() {
		super();
		this.type = ValidationType.Required;
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
