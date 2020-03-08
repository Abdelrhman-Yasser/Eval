package com.ejada.validations.complex;

import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.LengthParam;
import com.ejada.validations.params.OperatorParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class LengthValidationConfig.
 */
public class LengthValidationConfig implements ValidationConfig{

	/**
	 * The length.
	 */
	private ValidationParam<Integer> length ;
	
	/**
	 * The operator.
	 */
	private ValidationParam<LengthOperator> operator ;
	
	/**
	 * The lang.
	 */
	private ValidationParam<Language> lang ;
	
	/**
	 * The type.
	 */
	private ValidationType type ;
	
	/**
	 * Instantiates a new length validation config.
	 *
	 * @param length the length
	 * @param operator the operator
	 * @param lang the lang
	 */
	public LengthValidationConfig(int length, LengthOperator operator, Language lang) {
		super();
		this.length = new LengthParam(length);
		this.operator = new OperatorParam(operator);
		this.lang = new LangParam(lang);
		this.type = ValidationType.Length;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public ValidationType getType() {
		return type;
	}

	/**
	 * Gets the param.
	 *
	 * @param type the type
	 * @return the param
	 */
	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
			case Length:
				return this.length;
			case Operator:
				return this.operator;
			case Language:
				return this.lang;
			default:
				return null;
		}
	}

}
