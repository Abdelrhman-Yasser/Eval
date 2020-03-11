package com.ejada.validations.core;

import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.EmailResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class EmailValidator.
 */
public class EmailValidator implements Validator {

	/**
	 * The config.
	 */
	private EmailValidationConfig config;

	/**
	 * Instantiates a new email validator.
	 */
	public EmailValidator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new email validator.
	 *
	 * @param config the config
	 */
	public EmailValidator(EmailValidationConfig config) {
		super();
		this.config = config;
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
		return new EmailResult(field.matches("^(.+)@(.+)$"), fieldName,
				(Language) config.getParam(ParamType.Language).getValue());

	}

	/**
	 * Sets the config.
	 *
	 * @param T      the generic type
	 * @param config the new config
	 */
	@Override
	public <T> void setConfig(T config) {
		this.config = (EmailValidationConfig) config;
	}

}
