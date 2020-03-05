package com.ejada.validations.core;

import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

public class RequiredValidator implements Validator {

	RequiredValidationConfig config;
	
	public RequiredValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequiredValidator(RequiredValidationConfig config) {
		super();
		this.config = config ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ValidationResult validate(String field, String fieldName) {
		boolean valid = true ;
		valid &= field != "null" ;
		valid &= field != "Null" ;
		valid &= field != "{}" ;
		valid &= !field.trim().isEmpty();
		valid &= field != null ;
		return new RequiredResult(valid,fieldName,(Language)config.getParam(ParamType.Language).getValue());
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (RequiredValidationConfig) config ;
	}

}
