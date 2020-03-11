package com.ejada.validations.complex;

import javax.json.JsonObject;

import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.JsonConfigParam;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class JsonValidationConfig implements ValidationConfig {

	private JsonConfigParam config;
	private LangParam lang;
	private ValidationType type;

	public JsonValidationConfig(JsonObject config, Language lang) {
		this.config = new JsonConfigParam(config);
		this.lang = new LangParam(lang);
		this.type = ValidationType.Length;
	}

	@Override
	public ValidationType getType() {
		return this.type;
	}

	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
		case Json:
			return this.config;
		case Language:
			return this.lang;
		default:
			return null;
		}
	}

}
