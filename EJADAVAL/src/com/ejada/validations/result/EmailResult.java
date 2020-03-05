package com.ejada.validations.result;

import com.ejada.validations.nationalization.Language;

public class EmailResult implements ValidationResult{

	private final String message = "" ;
	private final String code = "" ;
	private String fieldName ;
	private boolean valid;

	public EmailResult(boolean valid, String fieldName, Language lang) {
		super();
		this.valid = valid ;
		this.fieldName = fieldName ;
	}

	@Override
	public String get_error_message() {
		return fieldName + " " + message;
	}

	@Override
	public boolean is_valid() {
		return valid;
	}


	@Override
	public String get_error_code() {
		return code;
	}

}
