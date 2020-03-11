package com.ejada.validations.core;

import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.result.ValidationResult;

/**
 * The Interface Validator.
 */
public interface Validator {

	/**
	 * Validate.
	 *
	 * @param field     the field
	 * @param FieldName the field name
	 * @return the validation result
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 * @throws ValidationConfigNotFound
	 */
	ValidationResult validate(String field, String FieldName) throws ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException, ValidationConfigNotFound;

	/**
	 * Sets the config.
	 *
	 * @param T      the generic type
	 * @param config the new config
	 */
	public <T> void setConfig(T config);

}
