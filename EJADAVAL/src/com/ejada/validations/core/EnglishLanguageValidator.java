package com.ejada.validations.core;

import com.ejada.validations.errors.EnglishLanguageResult;
import com.ejada.validations.errors.ValidationResult;

public class EnglishLanguageValidator implements Validator{
	
	@Override
	public ValidationResult validate(String field){
		return new EnglishLanguageResult(field.matches("^[a-zA-Z ]+$"));
	}

}
