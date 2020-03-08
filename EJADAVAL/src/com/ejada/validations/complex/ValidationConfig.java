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
	ValidationType getType() ;

	/**
	 * Gets the param.
	 *
	 * @param type the type
	 * @return the param
	 */
	ValidationParam<?> getParam(ParamType type);
	
}
