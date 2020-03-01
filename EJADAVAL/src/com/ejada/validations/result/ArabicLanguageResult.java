package com.ejada.validations.result;

public class ArabicLanguageResult implements ValidationResult {

	private final String message = "" ;
	private boolean valid;
	
	public ArabicLanguageResult(boolean valid) {
		super();
		this.valid = valid ;
	}

	@Override
	public String get_error_message() {
		return message;
	}

	@Override
	public boolean is_valid() {
		return valid;
	}

}