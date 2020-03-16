package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class NumericValidationConfig.
 */
public class NumericValidationConfig implements ValidationConfig {

	/**
	 * The type of validation.
	 */
	private ValidationType type;

	/**
	 * The language.
	 */
	private LangParam<?> lang;

	/**
	 * Instantiates a new numeric validation configuration.
	 *
	 * @param lang the language
	 * 
	 */
	public NumericValidationConfig(Language lang) {
		super();
		this.type = ValidationType.Number;
		this.lang = new LangParam<Language>(lang, ParamType.Language);
	}

	/**
	 * Instantiates a new numeric validation configuration.
	 *
	 * @param params the parameter
	 * @param lang   the language
	 * 
	 */
	public NumericValidationConfig(JsonObject params, LangParam<?> lang) {
		super();
		this.type = ValidationType.Number;
		this.lang = lang;
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
	 * 
	 */
	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
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
		if (obj.getClass() != NumericValidationConfig.class)
			return false;
		return true;
	}

}
