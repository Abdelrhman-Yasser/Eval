package com.ejada.validations.nationalization;

/**
 * The Enum Language.
 */
public enum Language {
	
	/**
	 * The English.
	 */
	English("EN"), /**
  * The Arabic.
  */
 Arabic("AR") ;
	
	
	/**
	 * The value.
	 */
	private String value;

	/**
	 * Instantiates a new language.
	 *
	 * @param value the value
	 */
	Language(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Gets the by code.
	 *
	 * @param code the code
	 * @return the by code
	 */
	public static Language getByCode(String code) {
		for (Language type : Language.values())
			if (type.getValue().equalsIgnoreCase(code))
				return type;
		return null;
	}
}
