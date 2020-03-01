package com.ejada.validations.params;

public class LengthParam implements ValidationParam<Integer> {
	
	private int length;

	public LengthParam(int length) {
		super();
		this.length = length;
	}

	@Override
	public Integer getValue() {
		return length;
	}

}
