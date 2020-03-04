package com.ejada.validations.nationalization;

public enum Language {
	
	English("EN"), Arabic("AR") ;
	
	
	private String value;

	Language(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Language getByCode(String code) {
		for (Language type : Language.values())
			if (type.getValue().equalsIgnoreCase(code))
				return type;
		return null;
	}
}
