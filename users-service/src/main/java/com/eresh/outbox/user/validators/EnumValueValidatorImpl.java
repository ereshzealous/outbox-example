package com.eresh.outbox.user.validators;



import com.eresh.outbox.user.util.NewsLetter;
import com.eresh.outbox.user.util.NewsLetterFrequencies;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
public class EnumValueValidatorImpl implements ConstraintValidator<EnumValueValidator, String> {

	private EnumValueValidator annotation;

	@Override
	public void initialize(EnumValueValidator constraintAnnotation) {
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		Object[] enumValues = this.annotation.enumClass()
		                                     .getEnumConstants();
		if (ArrayUtils.isNotEmpty(enumValues)) {
			if (enumValues[0] instanceof NewsLetter) {
				return Arrays.stream(enumValues)
				             .map(data -> (NewsLetter) data)
				             .filter(data -> StringUtils.equalsIgnoreCase(data.getNewsLetter(), value))
				             .findFirst()
				             .orElse(null) != null;
			}
			if (enumValues[0] instanceof NewsLetterFrequencies) {
				return Arrays.stream(enumValues)
				             .map(data -> (NewsLetterFrequencies) data)
				             .filter(data -> StringUtils.equalsIgnoreCase(data.getFrequency(), value))
				             .findFirst()
				             .orElse(null) != null;
			}
		}
		return false;
	}
}