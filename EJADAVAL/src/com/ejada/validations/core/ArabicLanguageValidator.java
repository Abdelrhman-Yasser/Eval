package com.ejada.validations.core;

import com.ejada.validations.result.ArabicLanguageResult;
import com.ejada.validations.result.ValidationResult;

public class ArabicLanguageValidator implements Validator{

	@Override
	public ValidationResult validate(String field){
		return new ArabicLanguageResult(field.matches("^[ا-ي ]+$"));
	}

}
