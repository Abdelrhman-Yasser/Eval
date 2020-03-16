package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Interface ValidationConfig.
 */
public interface ValidationConfig {

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	ValidationType getType();

	/**
	 * Gets the parameter.
	 *
	 * @param type the type
	 * @return the parameter
	 */
	ValidationParam<?> getParam(ParamType type);

}
