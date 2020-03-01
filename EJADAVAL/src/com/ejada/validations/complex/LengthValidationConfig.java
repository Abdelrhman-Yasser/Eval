package com.ejada.validations.complex;

import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.params.LengthParam;
import com.ejada.validations.params.OperatorParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class LengthValidationConfig implements ValidationConfig{

	private ValidationParam<Integer> length ;
	private ValidationParam<LengthOperator> operator ;
	private ValidationType type ;
	
	public LengthValidationConfig(int length, LengthOperator operator) {
		super();
		this.length = new LengthParam(length);
		this.operator = new OperatorParam(operator);
		this.type = ValidationType.Length;
	}

	@Override
	public ValidationType getType() {
		return type;
	}

	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
			case Length:
				return this.length;
			case Operator:
				return this.operator;
			default:
				return null;
		}
	}

}
