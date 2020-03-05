package com.ejada.validations.core;

import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.NumericResult;
import com.ejada.validations.result.ValidationResult;

public class NumericValidator implements Validator {

	private NumericValidationConfig config ;
	
	public NumericValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NumericValidator(NumericValidationConfig config) {
		super();
		this.config = config;
	}

	@Override
	public ValidationResult validate(String field, String fieldName) {
		return new NumericResult(field.matches("^[-+]?[0-9]+$"), fieldName,(Language)config.getParam(ParamType.Language).getValue());
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (NumericValidationConfig) config ;
	}

}
