package com.ejada.validations.result;

public class RequiredResult implements ValidationResult {

	private final String message = "" ;
	private final String code = "" ;
	private String fieldName ;
	private boolean valid;
	
	public RequiredResult(boolean valid, String fieldName) {
		super();
		this.valid = valid ;
		this.fieldName = fieldName ;
	}

	@Override
	public String get_error_message() {
		return this.fieldName + " " + message;
	}

	@Override
	public boolean is_valid() {
		return valid;
	}

	@Override
	public String get_error_code() {
		return this.code;
	}

}
