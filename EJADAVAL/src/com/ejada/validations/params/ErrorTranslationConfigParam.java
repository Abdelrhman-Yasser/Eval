package com.ejada.validations.params;

import java.io.File;

/**
 * The Class ErrorTranslationConfigParam.
 */
public class ErrorTranslationConfigParam implements ValidationParam<File> {

	/**
	 * The config.
	 */
	private File config;

	/**
	 * Instantiates a new error translation config param.
	 *
	 * @param config the config
	 */
	public ErrorTranslationConfigParam(File config) {
		super();
		this.config = config;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public File getValue() {
		return config;
	}

}
