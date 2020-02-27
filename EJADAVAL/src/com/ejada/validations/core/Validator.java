package com.ejada.validations.core;

import com.ejada.validations.errors.ValidationResult;

public interface Validator {

	ValidationResult validate(String field);

}
