package com.ejada.validations.exceptions;

public class WrongOperatorException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongOperatorException() {
	}

	public WrongOperatorException(String operator) {
		super(operator + " is not valid operator");
	}

	public WrongOperatorException(Throwable cause) {
		super(cause);
	}

	public WrongOperatorException(String operator, Throwable cause) {
		super(operator + " is not valid operator", cause);
	}

	public WrongOperatorException(String operator, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(operator + " is not valid operator", cause, enableSuppression, writableStackTrace);
	}

}
