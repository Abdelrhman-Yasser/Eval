package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class FloatValidationConfig.
 */
public class FloatValidationConfig implements ValidationConfig {

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * The lang.
	 */
	private LangParam<?> lang;

	/**
	 * Instantiates a new float validation config.
	 *
	 * @param lang the lang
	 */
	public FloatValidationConfig(Language lang) {
		super();
		this.type = ValidationType.Float;
		this.lang = new LangParam<Language>(lang, ParamType.Language);
	}

	/**
	 * Instantiates a new float validation config.
	 *
	 * @param params the params
	 * @param lang   the lang
	 */
	public FloatValidationConfig(JsonObject params, LangParam<?> lang) {
		super();
		this.type = ValidationType.Float;
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

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != FloatValidationConfig.class)
			return false;
		return true;
	}

}
