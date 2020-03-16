package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class EmailValidationConfig.
 */
public class EmailValidationConfig implements ValidationConfig {

	/**
	 * The type of validation.
	 */
	private ValidationType type;

	/**
	 * The language to populate errors.
	 */
	private LangParam<?> lang;

	/**
	 * Instantiates a new email validation configuration.
	 *
	 * @param lang the language
	 */
	public EmailValidationConfig(Language lang) {
		super();
		this.type = ValidationType.ArabicLang;
		this.lang = new LangParam<Language>(lang, ParamType.Language);
	}

	/**
	 * Instantiates a new email validation configuration.
	 *
	 * @param params the parameters
	 * @param lang   the language
	 */
	public EmailValidationConfig(JsonObject params, LangParam<?> lang) {
		super();
		this.type = ValidationType.Email;
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
		if (obj.getClass() != EmailValidationConfig.class)
			return false;
		return true;
	}

}
