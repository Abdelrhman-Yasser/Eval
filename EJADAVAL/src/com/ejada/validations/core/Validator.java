package com.ejada.validations.core;

import com.ejada.validations.result.ValidationResult;

/**
 * The Interface Validator.
 */
public interface Validator {

	/**
	 * Validate.
	 *
	 * @param field the field
	 * @param FieldName the field name
	 * @return the validation result
	 */
	ValidationResult validate(String field, String FieldName);

	/**
	 * Sets the config.
	 *
	 * @param T the generic type
	 * @param config the new config
	 */
	public <T> void setConfig(T config);
	
}
