package com.ejada.validations.core;

import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.LengthResult;
import com.ejada.validations.result.ValidationResult;

public class LengthValidator implements Validator{
	
	private LengthValidationConfig config ;
	
	public LengthValidator() {
		super();
	}

	public LengthValidator(LengthValidationConfig config) {
		super();
		this.config = config;
	}
	
	@Override
	public ValidationResult validate(String field, String fieldName) {
		// TODO Auto-generated method stub
		LengthOperator operator = (LengthOperator) this.config.getParam(ParamType.Operator).getValue() ;
		Integer length = (Integer) this.config.getParam(ParamType.Length).getValue() ;
		switch (operator) {
		case LESS:
			return new LengthResult(field.length() < length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		case GREATER:
			return new LengthResult(field.length() > length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		case EQUAL:
			return new LengthResult(field.length() == length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		}
		return null ;
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (LengthValidationConfig) config ;
	}

}
