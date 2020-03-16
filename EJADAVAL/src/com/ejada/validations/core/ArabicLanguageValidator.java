package com.ejada.validations.core;

import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.ArabicLanguageResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class ArabicLanguageValidator.
 */
public class ArabicLanguageValidator implements Validator {

	/**
	 * The validation configuration.
	 */
	private ArabicValidationConfig config;

	/**
	 * Instantiates a new Arabic language validator.
	 */
	public ArabicLanguageValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Arabic language validator.
	 *
	 * @param config the configuration
	 */
	public ArabicLanguageValidator(ArabicValidationConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Validate.
	 *
	 * @param field     the field to validate
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws ValidationConfigNotFound the validation configuration not found
	 *
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) throws ValidationConfigNotFound {
		return new ArabicLanguageResult(field.matches("^[ا-ي ]+$"), fieldName,
				(LangParam<?>) config.getParam(ParamType.Language));
	}

	/**
	 * Sets the configuration.
	 *
	 * @param <T>    the generic type
	 * @param config the new configuration
	 */
	@Override
	public <T> void setConfig(T config) {
		this.config = (ArabicValidationConfig) config;
	}

}
