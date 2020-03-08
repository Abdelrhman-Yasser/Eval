package com.ejada.validations.params;

/**
 * The Class DateFormatParam.
 */
public class DateFormatParam implements ValidationParam<String> {

	/**
	 * The date format.
	 */
	String dateFormat ;
	
	/**
	 * Instantiates a new date format param.
	 *
	 * @param dateFormat the date format
	 */
	public DateFormatParam(String dateFormat) {
		this.dateFormat = dateFormat ;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public String getValue() {
		return this.dateFormat ;
	}

}
