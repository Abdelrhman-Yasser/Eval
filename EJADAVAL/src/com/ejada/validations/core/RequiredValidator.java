package com.ejada.validations.core;

import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class RequiredValidator.
 */
public class RequiredValidator implements Validator {

	/**
	 * The validation configuration.
	 */
	private RequiredValidationConfig config;

	/**
	 * Instantiates a new required validator.
	 */
	public RequiredValidator() {
		super();
	}

	/**
	 * Instantiates a new required validator.
	 *
	 * @param config the configuration
	 * 
	 */
	public RequiredValidator(RequiredValidationConfig config) {
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
		boolean valid = true;
		valid &= field != "null";
		valid &= field != "Null";
		valid &= field != "{}";
		valid &= field != "[]";
		valid &= !field.trim().isEmpty();
		valid &= field != null;
		return new RequiredResult(valid, fieldName, (LangParam<?>) config.getParam(ParamType.Language));
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
		this.config = (RequiredValidationConfig) config;
	}

}
