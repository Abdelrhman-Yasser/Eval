package com.ejada.validations.core;

import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.NumericResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class NumericValidator.
 */
public class NumericValidator implements Validator {

	/**
	 * The validation configuration.
	 */
	private NumericValidationConfig config;

	/**
	 * Instantiates a new numeric validator.
	 */
	public NumericValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new numeric validator.
	 *
	 * @param config the configuration
	 */
	public NumericValidator(NumericValidationConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Validate.
	 *
	 * @param field     the field to be validated
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws ValidationConfigNotFound the validation configuration not found
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) throws ValidationConfigNotFound {
		return new NumericResult(field.matches("^[-+]?[0-9]+$"), fieldName,
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
		// TODO Auto-generated method stub
		this.config = (NumericValidationConfig) config;
	}

}
