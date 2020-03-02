package com.ejada.validations.result;

public class ArabicLanguageResult implements ValidationResult {

	private final String message = "" ;
	private final String code = "" ;
	private String fieldName ;
	private boolean valid;
	
	public ArabicLanguageResult(boolean valid, String fieldName) {
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
