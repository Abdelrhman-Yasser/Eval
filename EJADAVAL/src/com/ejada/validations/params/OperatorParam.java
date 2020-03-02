package com.ejada.validations.params;

import com.ejada.validations.core.enums.LengthOperator;

public class OperatorParam implements ValidationParam<LengthOperator> {

	private LengthOperator operator ;

	public OperatorParam(LengthOperator operator) {
		super();
		this.operator = operator;
	}

	@Override
	public LengthOperator getValue() {
		return operator;
	}
	
}
