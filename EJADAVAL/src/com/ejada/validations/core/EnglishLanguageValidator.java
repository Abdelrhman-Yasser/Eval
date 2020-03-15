package com.ejada.validations.core;

import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.EnglishLanguageResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class EnglishLanguageValidator.
 */
public class EnglishLanguageValidator implements Validator {

	/**
	 * The config.
	 */
	private EnglishValidationConfig config;

	/**
	 * Instantiates a new english language validator.
	 */
	public EnglishLanguageValidator() {
		super();
	}

	/**
	 * Instantiates a new english language validator.
	 *
	 * @param config the config
	 */
	public EnglishLanguageValidator(EnglishValidationConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Validate.
	 *
	 * @param field     the field
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws ValidationConfigNotFound the validation config not found
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) throws ValidationConfigNotFound {
		return new EnglishLanguageResult(field.matches("^[a-zA-Z ]+$"), fieldName,
				(LangParam<?>) config.getParam(ParamType.Language));
	}

	/**
	 * Sets the config.
	 *
	 * @param <T>    the generic type
	 * @param config the new config
	 */
	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (EnglishValidationConfig) config;
	}

}
