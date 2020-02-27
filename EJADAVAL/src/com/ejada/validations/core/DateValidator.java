package com.ejada.validations.core;

import java.text.SimpleDateFormat;

import com.ejada.validations.errors.DateResult;
import com.ejada.validations.errors.ValidationResult;

public class DateValidator implements Validator{

	@Override
	public ValidationResult validate(String field) {
		// TODO Auto-generated method stub
		
		if(field == null)
			return new DateResult(false) ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(field) ;
			return new DateResult(true) ;
		} catch (Exception e) {
			return new DateResult(false) ;
		}
	}

}
