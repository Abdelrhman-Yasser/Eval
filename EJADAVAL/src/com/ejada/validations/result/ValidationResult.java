package com.ejada.validations.result;

public interface ValidationResult{
	
	String get_error_message() ;
	
	boolean is_valid() ;
	
	String get_error_code() ;
}
