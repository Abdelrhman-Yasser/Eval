package com.ejada.validations.core;

import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.FloatResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class FloatValidator.
 */
public class FloatValidator implements Validator {

	/**
	 * The config.
	 */
	private FloatValidationConfig config ;
	
	/**
	 * Instantiates a new float validator.
	 */
	public FloatValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new float validator.
	 *
	 * @param config the config
	 */
	public FloatValidator(FloatValidationConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Validate.
	 *
	 * @param field the field
	 * @param fieldName the field name
	 * @return the validation result
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) {
		return new FloatResult(field.matches("^[-+]?[0-9]*\\.?[0-9]+$"),fieldName,(Language)config.getParam(ParamType.Language).getValue());
	}

	/**
	 * Sets the config.
	 *
	 * @param T the generic type
	 * @param config the new config
	 */
	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (FloatValidationConfig) config;
	}

}
