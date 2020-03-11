package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class RequiredValidationConfig.
 */
public class RequiredValidationConfig implements ValidationConfig {

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * The lang.
	 */
	private ValidationParam<Language> lang;

	/**
	 * Instantiates a new required validation config.
	 *
	 * @param lang the lang
	 */
	public RequiredValidationConfig(Language lang) {
		super();
		this.type = ValidationType.Required;
		this.lang = new LangParam(lang);
	}

	/**
	 * Instantiates a new required validation config.
	 *
	 * @param params the params
	 * @param lang   the lang
	 */
	public RequiredValidationConfig(JsonObject params, Language lang) {
		super();
		this.type = ValidationType.Required;
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

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj.getClass() != RequiredValidationConfig.class)
			return false;
		RequiredValidationConfig other = ((RequiredValidationConfig) obj);
		return other.getParam(ParamType.Language).getValue() == this.lang.getValue();
	}

}
