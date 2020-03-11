package com.ejada.validations.params;

import javax.json.JsonObject;

/**
 * The Class JsonConfigParam.
 */
public class JsonConfigParam implements ValidationParam<JsonObject> {

	/**
	 * The config.
	 */
	private JsonObject config;

	/**
	 * Instantiates a new json config param.
	 *
	 * @param config the config
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
