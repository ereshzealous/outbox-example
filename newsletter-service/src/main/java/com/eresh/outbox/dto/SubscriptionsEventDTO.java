package com.eresh.outbox.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class SubscriptionsEventDTO {
	private String userId;
	private String email;
	private List<NewsLetterSubscriptionDTO> subscriptions = Collections.emptyList();
}