package com.ejada.validations.core.enums;

public enum LengthOperator {
	
	LESS("LESS THAN") , 
	GREATER("GREATER THAN") , 
	EQUAL("EQUAL") ;
	
	private String value;

	LengthOperator(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static LengthOperator getByCode(String code) {
		for (LengthOperator type : LengthOperator.values())
			if (type.getValue().equalsIgnoreCase(code))
				return type;
		return null;
	}

}
