package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.LengthParam;
import com.ejada.validations.params.OperatorParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class LengthValidationConfig.
 */
public class LengthValidationConfig implements ValidationConfig {

	/**
	 * The length.
	 */
	private ValidationParam<Integer> length;

	/**
	 * The operator.
	 */
	private ValidationParam<LengthOperator> operator;

	/**
	 * The language.
	 */
	private LangParam<?> lang;

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * Instantiates a new length validation configuration.
	 *
	 * @param length   the length
	 * @param operator the operator
	 * @param lang     the language
	 */
	public LengthValidationConfig(int length, LengthOperator operator, Language lang) {
		super();
		this.length = new LengthParam(length);
		this.operator = new OperatorParam(operator);
		this.lang = new LangParam<Language>(lang, ParamType.Language);
		this.type = ValidationType.Length;
	}

	/**
	 * Instantiates a new length validation configuration.
	 *
	 * @param params the parameter
	 * @param lang   the language
	 * @throws MissingParameterException the missing parameter exception
	 * @throws WrongOperatorException    the wrong operator exception
	 */
	public LengthValidationConfig(JsonObject params, LangParam<?> lang)
			throws MissingParameterException, WrongOperatorException {
		super();
		this.lang = lang;
		this.type = ValidationType.Length;

		try {
			this.length = new LengthParam(params.getInt(ParamType.Length.toString()));
		} catch (Exception e) {
			throw new MissingParameterException(this.type + "-" + ParamType.Length);
		}

		String operatorParam = "";
		try {
			operatorParam = params.getString(ParamType.Operator.toString());
		} catch (Exception e) {
			throw new MissingParameterException(this.type + "-" + ParamType.Operator);
		}

		LengthOperator op = LengthOperator.getByCode(operatorParam);
		if (op == null)
			throw new WrongOperatorException(operatorParam);

		this.operator = new OperatorParam(op);

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
	 * Gets the parameter.
	 *
	 * @param type the type
	 * @return the parameter
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

	/**
	 * Equals.
	 *
	 * @param obj the object
	 * @return true, if successful
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != LengthValidationConfig.class)
			return false;
		LengthValidationConfig other = ((LengthValidationConfig) obj);
		return other.getParam(ParamType.Operator).getValue() == this.operator.getValue()
				&& other.getParam(ParamType.Length).getValue() == this.length.getValue();
	}

}
