package com.ejada.validations.core;

import java.text.SimpleDateFormat;

import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.DateResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class DateValidator.
 */
public class DateValidator implements Validator {

	/**
	 * The config.
	 */
	private DateValidationConfig config;

	/**
	 * Instantiates a new date validator.
	 */
	public DateValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new date validator.
	 *
	 * @param config the config
	 */
	public DateValidator(DateValidationConfig config) {
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
		if (field == null)
			return new DateResult(false, fieldName, (LangParam<?>) config.getParam(ParamType.Language));

		String dateFormat = (String) this.config.getParam(ParamType.DateFormat).getValue();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		sdf.setLenient(false);
		try {
			sdf.parse(field);
			return new DateResult(true, fieldName, (LangParam<?>) config.getParam(ParamType.Language));
		} catch (Exception e) {
			return new DateResult(false, fieldName, (LangParam<?>) config.getParam(ParamType.Language));
		}
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
		this.config = (DateValidationConfig) config;
	}

}
