package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class ArabicValidationConfig.
 */
public class ArabicValidationConfig implements ValidationConfig {

	/**
	 * The type of validation.
	 */
	private ValidationType type;

	/**
	 * The language can be a file or a language based on way of construction .
	 */
	private LangParam<?> lang;

	/**
	 * Instantiates a new Arabic validation configuration.
	 *
	 * @param lang the language
	 */
	public ArabicValidationConfig(Language lang) {
		super();
		this.type = ValidationType.ArabicLang;
		this.lang = new LangParam<Language>(lang, ParamType.Language);
	}

	/**
	 * Instantiates a new Arabic validation configuration.
	 *
	 * @param params the JSON validation object for validations
	 * @param lang   the language
	 * 
	 */
	public ArabicValidationConfig(JsonObject params, LangParam<?> lang) {
		super();
		this.type = ValidationType.ArabicLang;
		this.lang = lang;
	}

	/**
	 * Gets the type of the validation.
	 *
	 * @return the type
	 */
	@Override
	public ValidationType getType() {
		return type;
	}

	/**
	 * Gets the parameters based on type.
	 *
	 * @param type the type
	 * @return the parameter
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
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != ArabicValidationConfig.class)
			return false;
		return true;
	}

}
