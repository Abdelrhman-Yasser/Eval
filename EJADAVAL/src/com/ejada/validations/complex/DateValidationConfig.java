package com.ejada.validations.complex;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.DateFormatParam;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class DateValidationConfig implements ValidationConfig{
	
	private ValidationType type ;
	private LangParam lang ;
	private DateFormatParam dateFormat ;
	
	public DateValidationConfig(String dateFormat ,Language lang) {
		super();
		this.type = ValidationType.Date;
		this.lang = new LangParam(lang);
		this.dateFormat = new DateFormatParam(dateFormat) ;
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
		case DateFormat:
			return this.dateFormat;
		default:
			return null ;
		}
	}

}
