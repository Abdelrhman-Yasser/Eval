package com.ejada.validations.core;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;

import com.ejada.validations.complex.ComplexIteratorValidator;
import com.ejada.validations.complex.JsonValidationConfig;
import com.ejada.validations.complex.ValidationConfig;
import com.ejada.validations.complex.ValidationSerializer;
import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class JsonValidator.
 */
public class JsonValidator {

	/**
	 * The validation configuration.
	 */
	private JsonValidationConfig config;

	/**
	 * Instantiates a new JSON validator.
	 */
	public JsonValidator() {
		super();
	}

	/**
	 * Validate.
	 *
	 * @param field the field to be validated
	 * @return the validation results
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation configuration not
	 *                                         found
	 */
	public ArrayList<ValidationResult> validate(String field) throws ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException, ValidationConfigNotFound {

		JsonObject obj = Json.createReader(new StringReader(field)).readObject();

		ComplexIteratorValidator validator = new ComplexIteratorValidator();

		HashMap<String, ArrayList<ValidationConfig>> configMap = ValidationSerializer.serializeValidations(this.config);

		return validator.validate(obj, configMap);
	}

	/**
	 * Sets the configuration.
	 *
	 * @param config the new configuration
	 */
	public void setConfig(JsonValidationConfig config) {
		this.config = config;
	}

}
