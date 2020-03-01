package com.ejada.validations.core;

import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

public class RequiredValidator implements Validator {

	@Override
	public ValidationResult validate(String field) {
		boolean valid = true ;
		valid &= field != "null" ;
		valid &= field != "Null" ;
		valid &= field != "{}" ;
		valid &= !field.isBlank();
		return new RequiredResult(valid);
	}

}
