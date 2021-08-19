package com.eresh.outbox.dto;

import lombok.Data;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class NewsLetterSubscriptionDTO {
	private String frequency;
	private String newsLetter;
}