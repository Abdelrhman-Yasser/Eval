package com.ejada.validations.core;

import com.ejada.validations.result.NumericResult;
import com.ejada.validations.result.ValidationResult;

public class NumericValidator implements Validator {

	@Override
	public ValidationResult validate(String field) {
		return new NumericResult(field.matches("^[-+]?[0-9]+$"));
	}

}
