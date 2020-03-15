package com.ejada.validations.exceptions;

/**
 * The Class ValidationConfigNotFound.
 */
public class ValidationConfigNotFound extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 4639770152877972991L;

	/**
	 * Instantiates a new validation config not found.
	 */
	public ValidationConfigNotFound() {
		super("Validation configurations file not found or not accessible");
	}

	/**
	 * Instantiates a new validation config not found.
	 *
	 * @param file the file
	 */
	public ValidationConfigNotFound(String file) {
		super("Validation configurations  " + file + "  not found or not accessible");
	}

	/**
	 * Instantiates a new validation config not found.
	 *
	 * @param cause the cause
	 */
	public ValidationConfigNotFound(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new validation config not found.
	 *
	 * @param file  the file
	 * @param cause the cause
	 */
	public ValidationConfigNotFound(String file, Throwable cause) {
		super("Validation configurations  " + file + "  not found or not accessible", cause);
	}

	/**
	 * Instantiates a new validation config not found.
	 *
	 * @param file               the file
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public ValidationConfigNotFound(String file, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super("Validation configurations  " + file + "  not found or not accessible", cause, enableSuppression,
				writableStackTrace);
	}

}
