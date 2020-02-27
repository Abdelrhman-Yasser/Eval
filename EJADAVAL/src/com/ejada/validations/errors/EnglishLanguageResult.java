package com.ejada.validations.errors;

public class EnglishLanguageResult implements ValidationResult {

	private final String message = "" ;
	private boolean valid;
	
	public EnglishLanguageResult(boolean valid) {
		super();
		this.valid = valid ;
	}

	@Override
	public String get_error_message() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public boolean is_valid() {
		// TODO Auto-generated method stub
		return valid;
	}


}