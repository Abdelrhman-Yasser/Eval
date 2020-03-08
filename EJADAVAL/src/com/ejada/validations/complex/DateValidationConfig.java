package com.ejada.validations.complex;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.DateFormatParam;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class DateValidationConfig.
 */
public class DateValidationConfig implements ValidationConfig{
	
	/**
	 * The type.
	 */
	private ValidationType type ;
	
	/**
	 * The lang.
	 */
	private LangParam lang ;
	
	/**
	 * The date format.
	 */
	private DateFormatParam dateFormat ;
	
	/**
	 * Instantiates a new date validation config.
	 *
	 * @param dateFormat the date format
	 * @param lang the lang
	 */
	public DateValidationConfig(String dateFormat ,Language lang) {
		super();
		this.type = ValidationType.Date;
		this.lang = new LangParam(lang);
		this.dateFormat = new DateFormatParam(dateFormat) ;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public ValidationType getType() {
		return type;
	}

	/**
	 * Gets the param.
	 *
	 * @param type the type
	 * @return the param
	 */
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
