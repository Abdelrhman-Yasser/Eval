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
	 * Validate field against specific validation.
	 *
	 * @param field     the field to be validated
	 * @param FieldName the field name
	 * @return the validation result
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation configuration not
	 *                                         found
	 */
	ValidationResult validate(String field, String FieldName) throws ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException, ValidationConfigNotFound;

	/**
	 * Sets the configuration.
	 *
	 * @param <T>    the generic type
	 * @param config the new configuration
	 */
	public <T> void setConfig(T config);

}
