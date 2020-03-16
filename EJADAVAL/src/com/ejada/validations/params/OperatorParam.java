package com.ejada.validations.params;

import com.ejada.validations.core.enums.LengthOperator;

/**
 * The Class OperatorParam.
 */
public class OperatorParam implements ValidationParam<LengthOperator> {

	/**
	 * The operator.
	 */
	private LengthOperator operator;

	/**
	 * Instantiates a new operator parameter.
	 *
	 * @param operator the operator
	 */
	public OperatorParam(LengthOperator operator) {
		super();
		this.operator = operator;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public LengthOperator getValue() {
		return operator;
	}

}
