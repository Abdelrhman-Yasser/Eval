package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.DateFormatParam;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

/**
 * The Class DateValidationConfig.
 */
public class DateValidationConfig implements ValidationConfig {

	/**
	 * The type.
	 */
	private ValidationType type;

	/**
	 * The lang.
	 */
	private LangParam<?> lang;

	/**
	 * The date format.
	 */
	private DateFormatParam dateFormat;

	/**
	 * Instantiates a new date validation config.
	 *
	 * @param dateFormat the date format
	 * @param lang       the lang
	 */
	public DateValidationConfig(String dateFormat, Language lang) {
		super();
		this.type = ValidationType.Date;
		this.lang = new LangParam<Language>(lang, ParamType.Language);
		this.dateFormat = new DateFormatParam(dateFormat);
	}

	/**
	 * Instantiates a new date validation config.
	 *
	 * @param params the params
	 * @param lang   the lang
	 * @throws MissingParameterException the missing parameter exception
	 */
	public DateValidationConfig(JsonObject params, LangParam<?> lang) throws MissingParameterException {
		super();
		this.type = ValidationType.Date;
		this.lang = lang;

		try {
			this.dateFormat = new DateFormatParam(params.getString(ParamType.DateFormat.toString()));
		} catch (Exception e) {
			throw new MissingParameterException(this.type + "-" + ParamType.DateFormat);
		}

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
			return null;
		}
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != DateValidationConfig.class)
			return false;
		DateValidationConfig other = ((DateValidationConfig) obj);
		return other.getParam(ParamType.DateFormat).getValue().equals(this.dateFormat.getValue());
	}

}
