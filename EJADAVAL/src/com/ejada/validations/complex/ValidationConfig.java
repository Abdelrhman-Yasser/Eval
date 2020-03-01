package com.ejada.validations.complex;

import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public interface ValidationConfig {

	ValidationType getType() ;

	ValidationParam<?> getParam(ParamType type);
	
}
