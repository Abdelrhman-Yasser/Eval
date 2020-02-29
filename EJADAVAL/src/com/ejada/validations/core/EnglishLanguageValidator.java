package com.ejada.validations.core;

import com.ejada.validations.result.EnglishLanguageResult;
import com.ejada.validations.result.ValidationResult;

public class EnglishLanguageValidator implements Validator{
	
	@Override
	public ValidationResult validate(String field){
		return new EnglishLanguageResult(field.matches("^[a-zA-Z ]+$"));
	}

}
