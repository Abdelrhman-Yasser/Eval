package com.ejada.validations.result;

public class NumericResult implements ValidationResult {

	private final String message = "" ;
	private boolean valid;
	
	public NumericResult(boolean valid) {
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
