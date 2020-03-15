package com.ejada.validations.complex;

import java.util.ArrayList;

import com.ejada.validations.core.Validator;
import com.ejada.validations.core.ValidatorFactory;
import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class ComplexValidator.
 */
public class ComplexValidator {

	/**
	 * Validate.
	 *
	 * @param field     the field
	 * @param fieldName the field name
	 * @param configs   the configs
	 * @return the array list
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation config not found
	 */
	public static ArrayList<ValidationResult> validate(String field, String fieldName,
			ArrayList<ValidationConfig> configs) throws ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, ValidationConfigNotFound {
		ArrayList<ValidationResult> results = new ArrayList<ValidationResult>();
		for (ValidationConfig conf : configs) {
			Validator val = ValidatorFactory.getValidator(conf.getType());
			val.setConfig(conf);
			results.add(val.validate(field, fieldName));
		}
		return results;
	}

}
