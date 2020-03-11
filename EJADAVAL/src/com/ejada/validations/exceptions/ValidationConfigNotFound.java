package com.ejada.validations.exceptions;

public class ValidationConfigNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4639770152877972991L;

	public ValidationConfigNotFound() {
		super("Validation configurations file not found or not accessible");
	}

	public ValidationConfigNotFound(String file) {
		super("Validation configurations  " + file + "  not found or not accessible");
	}

	public ValidationConfigNotFound(Throwable cause) {
		super(cause);
	}

	public ValidationConfigNotFound(String file, Throwable cause) {
		super("Validation configurations  " + file + "  not found or not accessible", cause);
	}

	public ValidationConfigNotFound(String file, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super("Validation configurations  " + file + "  not found or not accessible", cause, enableSuppression,
				writableStackTrace);
	}

}
