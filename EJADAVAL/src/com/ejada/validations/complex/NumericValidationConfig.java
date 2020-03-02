package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class NumericValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public NumericValidationConfig() {
		super();
		this.type = ValidationType.Number;
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
