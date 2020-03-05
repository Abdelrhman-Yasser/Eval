package com.ejada.validations.params;

public class DateFormatParam implements ValidationParam<String> {

	String dateFormat ;
	
	public DateFormatParam(String dateFormat) {
		this.dateFormat = dateFormat ;
	}

	@Override
	public String getValue() {
		return this.dateFormat ;
	}

}
