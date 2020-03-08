package com.ejada.validations.core;

import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.LengthResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class LengthValidator.
 */
public class LengthValidator implements Validator{
	
	/**
	 * The config.
	 */
	private LengthValidationConfig config ;
	
	/**
	 * Instantiates a new length validator.
	 */
	public LengthValidator() {
		super();
	}

	/**
	 * Instantiates a new length validator.
	 *
	 * @param config the config
	 */
	public LengthValidator(LengthValidationConfig config) {
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
		// TODO Auto-generated method stub
		LengthOperator operator = (LengthOperator) this.config.getParam(ParamType.Operator).getValue() ;
		Integer length = (Integer) this.config.getParam(ParamType.Length).getValue() ;
		switch (operator) {
		case LESS:
			return new LengthResult(field.length() < length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		case GREATER:
			return new LengthResult(field.length() > length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		case EQUAL:
			return new LengthResult(field.length() == length,fieldName,(Language)config.getParam(ParamType.Language).getValue());
		}
		return null ;
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
		this.config = (LengthValidationConfig) config ;
	}

}
