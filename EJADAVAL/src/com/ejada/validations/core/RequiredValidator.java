package com.ejada.validations.core;

import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class RequiredValidator.
 */
public class RequiredValidator implements Validator {

	/**
	 * The config.
	 */
	private RequiredValidationConfig config;

	/**
	 * Instantiates a new required validator.
	 */
	public RequiredValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new required validator.
	 *
	 * @param config the config
	 */
	public RequiredValidator(RequiredValidationConfig config) {
		super();
		this.config = config;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate.
	 *
	 * @param field     the field
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws ValidationConfigNotFound
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) throws ValidationConfigNotFound {
		boolean valid = true;
		valid &= field != "null";
		valid &= field != "Null";
		valid &= field != "{}";
		valid &= !field.trim().isEmpty();
		valid &= field != null;
		return new RequiredResult(valid, fieldName, (Language) config.getParam(ParamType.Language).getValue());
	}

	/**
	 * Sets the config.
	 *
	 * @param T      the generic type
	 * @param config the new config
	 */
	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (RequiredValidationConfig) config;
	}

}
