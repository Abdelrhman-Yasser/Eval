package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class DateValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	
	public DateValidationConfig() {
		super();
		this.type = ValidationType.Date;
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
