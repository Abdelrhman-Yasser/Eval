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
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.ValidationResult;

public class JsonValidator {

	private JsonValidationConfig config;

	/**
	 * Instantiates a new length validator.
	 *
	 * @param config the config
	 */
	public JsonValidator() {
		super();
	}

	/**
	 * Validate.
	 *
	 * @param field     the field
	 * @param fieldName the field name
	 * @return the validation result
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 * @throws ValidationConfigNotFound
	 */
	public ArrayList<ValidationResult> validate(String field) throws ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException, ValidationConfigNotFound {

		Language lang = (Language) this.config.getParam(ParamType.Language).getValue();
		JsonObject config = (JsonObject) this.config.getParam(ParamType.Json).getValue();
		JsonObject obj = Json.createReader(new StringReader(field)).readObject();

		ComplexIteratorValidator validator = new ComplexIteratorValidator();
		HashMap<String, ArrayList<ValidationConfig>> configMap = ValidationSerializer.serialzieValidations(config,
				lang);

		return validator.validate(obj, configMap);
	}

	public void setConfig(JsonValidationConfig config) {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
