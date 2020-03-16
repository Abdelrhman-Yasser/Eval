package com.ejada.validations.params;

/**
 * The Class LangParam.
 *
 * @param <T> the generic type
 */
public class LangParam<T> implements ValidationParam<T> {

	/**
	 * The language.
	 */
	private T lang;

	/**
	 * The type.
	 */
	private ParamType type;

	/**
	 * Instantiates a new language param.
	 *
	 * @param lang            the language
	 * @param translationType the translation type
	 */
	public LangParam(T lang, ParamType translationType) {
		super();
		this.type = translationType;
		this.lang = lang;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public T getValue() {
		return lang;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ParamType getType() {
		return type;
	}

}
