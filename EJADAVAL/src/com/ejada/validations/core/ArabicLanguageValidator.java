package com.ejada.validations.core;

import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.ArabicLanguageResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class ArabicLanguageValidator.
 */
public class ArabicLanguageValidator implements Validator {

	/**
	 * The config.
	 */
	private ArabicValidationConfig config;

	/**
	 * Instantiates a new arabic language validator.
	 */
	public ArabicLanguageValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new arabic language validator.
	 *
	 * @param config the config
	 */
	public ArabicLanguageValidator(ArabicValidationConfig config) {
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
		return new ArabicLanguageResult(field.matches("^[ا-ي ]+$"), fieldName,
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
		// TODO Auto-generated method stub
		this.config = (ArabicValidationConfig) config;
	}

}
