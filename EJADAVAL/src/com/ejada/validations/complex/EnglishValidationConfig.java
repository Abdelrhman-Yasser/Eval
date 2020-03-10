package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class EnglishValidationConfig.
 */
public class EnglishValidationConfig implements ValidationConfig {

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * The lang.
	 */
	private ValidationParam<Language> lang;

	/**
	 * Instantiates a new english validation config.
	 *
	 * @param lang the lang
	 */
	public EnglishValidationConfig(Language lang) {
		super();
		this.type = ValidationType.EnglishLang;
		this.lang = new LangParam(lang);
	}

	/**
	 * Instantiates a new english validation config.
	 *
	 * @param params the params
	 * @param lang   the lang
	 */
	public EnglishValidationConfig(JsonObject params, Language lang) {
		super();
		this.type = ValidationType.EnglishLang;
		this.lang = new LangParam(lang);
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
		case Language:
			return this.lang;
		default:
			return null;
		}
	}

}
