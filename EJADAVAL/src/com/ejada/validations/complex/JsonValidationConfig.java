package com.ejada.validations.complex;

import java.io.File;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.JsonConfigParam;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class JsonValidationConfig.
 */
public class JsonValidationConfig implements ValidationConfig {

	/**
	 * The configuration.
	 */
	private JsonConfigParam config;

	/**
	 * The language.
	 */
	private LangParam<?> lang;

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * Instantiates a new JSON validation configuration.
	 *
	 * @param config          the configuration
	 * @param translationFile the translation file
	 */
	public JsonValidationConfig(JsonObject config, File translationFile) {
		this.config = new JsonConfigParam(config);

		if (translationFile == null)
			this.lang = new LangParam<Language>(Language.English, ParamType.Language);
		else
			this.lang = new LangParam<File>(translationFile, ParamType.TranslationBundle);

		this.type = ValidationType.Length;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 * 
	 */
	@Override
	public ValidationType getType() {
		return this.type;
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
		case Json:
			return this.config;
		case Language:
			return this.lang;
		default:
			return null;
		}
	}

}
