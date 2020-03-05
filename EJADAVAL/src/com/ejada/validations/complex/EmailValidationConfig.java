package com.ejada.validations.complex;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class EmailValidationConfig implements ValidationConfig {

	private ValidationType type ;
	private ValidationParam<Language> lang ;
	
	public EmailValidationConfig(Language lang) {
		super();
		this.type = ValidationType.ArabicLang ;
		this.lang = new LangParam(lang);
	}

	@Override
	public ValidationType getType() {
		return type;
	}

	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
		case Language:
			return this.lang;
		default:
			return null ;
		}
	}

}