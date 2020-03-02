package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class FloatValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public FloatValidationConfig() {
		super();
		this.type = ValidationType.Float;
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
