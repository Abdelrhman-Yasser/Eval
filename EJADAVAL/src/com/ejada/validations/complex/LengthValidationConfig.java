package com.ejada.validations.complex;

import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.LengthParam;
import com.ejada.validations.params.OperatorParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.params.ValidationParam;

public class LengthValidationConfig implements ValidationConfig{

	private ValidationParam<Integer> length ;
	private ValidationParam<LengthOperator> operator ;
	private ValidationParam<Language> lang ;
	private ValidationType type ;
	
	public LengthValidationConfig(int length, LengthOperator operator, Language lang) {
		super();
		this.length = new LengthParam(length);
		this.operator = new OperatorParam(operator);
		this.lang = new LangParam(lang);
		this.type = ValidationType.Length;
	}

	@Override
	public ValidationType getType() {
		return type;
	}

	@Override
	public ValidationParam<?> getParam(ParamType type) {
		switch (type) {
			case Length:
				return this.length;
			case Operator:
				return this.operator;
			case Language:
				return this.lang;
			default:
				return null;
		}
	}

}
