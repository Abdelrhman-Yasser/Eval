package com.ejada.validations.core;

import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.ArabicLanguageResult;
import com.ejada.validations.result.ValidationResult;

public class ArabicLanguageValidator implements Validator{

	private ArabicValidationConfig config;
	
	public ArabicLanguageValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArabicLanguageValidator(ArabicValidationConfig config) {
		super();
		this.config = config;
	}

	@Override
	public ValidationResult validate(String field, String fieldName){
		return new ArabicLanguageResult(field.matches("^[ا-ي ]+$"),fieldName,(Language)config.getParam(ParamType.Language).getValue());
	}

	@Override
	public <T> void setConfig(T config) {
		// TODO Auto-generated method stub
		this.config = (ArabicValidationConfig) config;
	}

}
