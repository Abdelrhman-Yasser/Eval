package com.ejada.validations.api;

import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.result.ValidationResult;

public class API {

	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldLength(
			@Parameter String fieldName,
			@Parameter String field,
			@Parameter String operator,
			@Parameter Integer length,
			@Parameter String language){
		
		
		ValidationResult result = new LengthValidator(
				new LengthValidationConfig(
						length,
						LengthOperator.getByCode(operator),
						Language.getByCode(language)
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;
	}
	
	
}
