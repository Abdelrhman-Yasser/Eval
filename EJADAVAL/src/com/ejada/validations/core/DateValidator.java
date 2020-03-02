package com.ejada.validations.core;

import java.text.SimpleDateFormat;

import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.result.DateResult;
import com.ejada.validations.result.ValidationResult;

public class DateValidator implements Validator{

	DateValidationConfig config;
	
	public DateValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateValidator(DateValidationConfig config) {
		super();
		this.config = config;
	}

	@Override
	public ValidationResult validate(String field, String fieldName) {
		if(field == null)
			return new DateResult(false,fieldName) ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(field) ;
			return new DateResult(true,fieldName) ;
		} catch (Exception e) {
			return new DateResult(false,fieldName) ;
		}
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (DateValidationConfig) config;
	}

}
