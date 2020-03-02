package com.ejada.validations.result;

import com.ejada.validations.nationalization.Language;

public class ArabicLanguageResult implements ValidationResult {

	private final String message = "" ;
	private final String code = "" ;
	private String fieldName ;
	private boolean valid;
	private Language lang;
	
	public ArabicLanguageResult(boolean valid, String fieldName, Language lang) {
		super();
		this.valid = valid ;
		this.fieldName = fieldName ;
		this.lang = lang ;
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
