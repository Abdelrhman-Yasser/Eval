package com.ejada.validations.core;

import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.errors.LengthResult;
import com.ejada.validations.errors.ValidationResult;

public class LengthValidator implements Validator{
	
	LengthOperator operator;
	int length;
	
	public LengthValidator(LengthOperator operator, int length) {
		super();
		this.operator = operator ;
		this.length = length ;
	}
	
	public void setOperator(LengthOperator operator) {
		this.operator = operator;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public ValidationResult validate(String field) {
		// TODO Auto-generated method stub
		switch (operator) {
		case LESS:
			return new LengthResult(field.length() < this.length);
		case GREATER:
			return new LengthResult(field.length() > this.length);
		case EQUAL:
			return new LengthResult(field.length() == this.length);
		}
		return null ;
	}

}
