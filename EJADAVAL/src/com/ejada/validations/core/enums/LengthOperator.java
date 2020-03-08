package com.ejada.validations.core.enums;

/**
 * The Enum LengthOperator.
 */
public enum LengthOperator {
	
	/**
	 * The less.
	 */
	LESS("LESS THAN") , 
	
	/**
	 * The greater.
	 */
	GREATER("GREATER THAN") , 
	
	/**
	 * The equal.
	 */
	EQUAL("EQUAL") ;
	
	/**
	 * The value.
	 */
	private String value;

	/**
	 * Instantiates a new length operator.
	 *
	 * @param value the value
	 */
	LengthOperator(String value) {
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
	public static LengthOperator getByCode(String code) {
		for (LengthOperator type : LengthOperator.values())
			if (type.getValue().equalsIgnoreCase(code))
				return type;
		return null;
	}

}
