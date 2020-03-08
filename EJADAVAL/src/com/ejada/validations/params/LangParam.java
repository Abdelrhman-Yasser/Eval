package com.ejada.validations.params;

import com.ejada.validations.nationalization.Language;

/**
 * The Class LangParam.
 */
public class LangParam implements ValidationParam<Language> {
	
	/**
	 * The lang.
	 */
	private Language lang;

	/**
	 * Instantiates a new lang param.
	 *
	 * @param lang the lang
	 */
	public LangParam(Language lang) {
		super();
		this.lang = lang;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public Language getValue() {
		return lang;
	}

}
