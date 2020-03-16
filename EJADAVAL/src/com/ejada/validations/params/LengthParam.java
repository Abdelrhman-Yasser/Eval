package com.ejada.validations.params;

/**
 * The Class LengthParam.
 */
public class LengthParam implements ValidationParam<Integer> {

	/**
	 * The length.
	 */
	private int length;

	/**
	 * Instantiates a new length parameter.
	 *
	 * @param length the length
	 */
	public LengthParam(int length) {
		super();
		this.length = length;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public Integer getValue() {
		return length;
	}

}
