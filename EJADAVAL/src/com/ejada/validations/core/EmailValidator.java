package com.ejada.validations.core;

import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.EmailResult;
import com.ejada.validations.result.ValidationResult;

public class EmailValidator implements Validator {

	private EmailValidationConfig config;
	
	public EmailValidator() {
		// TODO Auto-generated constructor stub
	}
	
	public EmailValidator(EmailValidationConfig config) {
		super();
		this.config = config;
	}


	@Override
	public ValidationResult validate(String field, String fieldName) {
		return new EmailResult(field.matches("^(.+)@(.+)$"),fieldName,(Language)config.getParam(ParamType.Language).getValue());

	}

	@Override
	public <T> void setConfig(T config) {
		this.config = (EmailValidationConfig) config;
	}

}
