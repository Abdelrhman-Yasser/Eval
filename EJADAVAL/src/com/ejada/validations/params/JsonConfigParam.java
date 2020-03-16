package com.ejada.validations.params;

import javax.json.JsonObject;

/**
 * The Class JsonConfigParam.
 */
public class JsonConfigParam implements ValidationParam<JsonObject> {

	/**
	 * The configuration.
	 */
	private JsonObject config;

	/**
	 * Instantiates a new JSON configuration parameter.
	 *
	 * @param config the configuration
	 */
	public JsonConfigParam(JsonObject config) {
		super();
		this.config = config;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public JsonObject getValue() {
		return config;
	}

}
