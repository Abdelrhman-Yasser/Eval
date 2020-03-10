package com.ejada.validations.complex;

/**
 * The Enum ValidationType.
 */
public enum ValidationType {

	/**
	 * The Required.
	 */
	Required("Required"),
	/**
	 * The Number.
	 */
	Number("Number"),
	/**
	 * The Float.
	 */
	Float("Float"),
	/**
	 * The Length.
	 */
	Length("Length"),
	/**
	 * The Arabic lang.
	 */
	ArabicLang("ArabicLang"),
	/**
	 * The English lang.
	 */
	EnglishLang("EnglishLang"),
	/**
	 * The Date.
	 */
	Date("Date"),
	/**
	 * The Email.
	 */
	Email("Email");

	private String value;

	/**
	 * Instantiates a new length operator.
	 *
	 * @param value the value
	 */
	ValidationType(String value) {
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
	public static ValidationType getByCode(String code) {
		for (ValidationType type : ValidationType.values())
			if (type.getValue().equalsIgnoreCase(code))
				return type;
		return null;
	}
}
