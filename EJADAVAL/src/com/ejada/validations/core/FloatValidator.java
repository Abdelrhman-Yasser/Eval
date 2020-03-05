package com.ejada.validations.core;

import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.FloatResult;
import com.ejada.validations.result.ValidationResult;

public class FloatValidator implements Validator {

	private FloatValidationConfig config ;
	
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
		return new FloatResult(field.matches("^[-+]?[0-9]*\\.?[0-9]+$"),fieldName,(Language)config.getParam(ParamType.Language).getValue());
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (FloatValidationConfig) config;
	}

}
