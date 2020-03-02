package com.ejada.validations.params;

import com.ejada.validations.nationalization.Language;

public class LangParam implements ValidationParam<Language> {
	
	private Language lang;

	public LangParam(Language lang) {
		super();
		this.lang = lang;
	}

	@Override
	public Language getValue() {
		return lang;
	}

}
