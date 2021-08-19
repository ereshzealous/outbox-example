package com.eresh.outbox.user.dto;

import com.eresh.outbox.user.util.NewsLetter;
import com.eresh.outbox.user.util.NewsLetterFrequencies;
import com.eresh.outbox.user.validators.EnumValueValidator;
import lombok.Data;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class NewsLetterSubscriptionDTO {
	@EnumValueValidator(enumClass = NewsLetterFrequencies.class, message = "Frequency Is Invalid")
	private String frequency;
	@EnumValueValidator(enumClass = NewsLetter.class, message = "News Letter Is Invalid")
	private String newsLetter;
}