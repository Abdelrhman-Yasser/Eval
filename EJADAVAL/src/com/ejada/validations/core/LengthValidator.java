package com.ejada.validations.core;

import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.LengthResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class LengthValidator.
 */
public class LengthValidator implements Validator {

	/**
	 * The validation configuration.
	 */
	private LengthValidationConfig config;

	/**
	 * Instantiates a new length validator.
	 */
	public LengthValidator() {
		super();
	}

	/**
	 * Instantiates a new length validator.
	 *
	 * @param config the configuration
	 * 
	 */
	public LengthValidator(LengthValidationConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Validate field against length validations.
	 *
	 * @param field     the field to be validated
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws ValidationConfigNotFound the validation configuration not found
	 */
	@Override
	public ValidationResult validate(String field, String fieldName) throws ValidationConfigNotFound {
		// TODO Auto-generated method stub
		LengthOperator operator = (LengthOperator) this.config.getParam(ParamType.Operator).getValue();
		Integer length = (Integer) this.config.getParam(ParamType.Length).getValue();
		switch (operator) {
		case LESS:
			return new LengthResult(field.length() < length, fieldName,
					(LangParam<?>) config.getParam(ParamType.Language));
		case GREATER:
			return new LengthResult(field.length() > length, fieldName,
					(LangParam<?>) config.getParam(ParamType.Language));
		case EQUAL:
			return new LengthResult(field.length() == length, fieldName,
					(LangParam<?>) config.getParam(ParamType.Language));
		}
		return null;
	}

	/**
	 * Sets the configuration.
	 *
	 * @param <T>    the generic type
	 * @param config the new configuration
	 * 
	 */
	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (LengthValidationConfig) config;
	}

}
