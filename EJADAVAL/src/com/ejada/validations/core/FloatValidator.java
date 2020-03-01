package com.ejada.validations.core;

import com.ejada.validations.result.FloatResult;
import com.ejada.validations.result.ValidationResult;

public class FloatValidator implements Validator {

	@Override
	public ValidationResult validate(String field) {
		return new FloatResult(field.matches("^[-+]?[0-9]*\\.?[0-9]+$"));
	}

}
