package com.eresh.outbox.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
public interface NewsLetterSubscriptionBindings {
	String NEWS_LETTER_SUBSCRIPTION_IN = "news-letter-subscription-in";

	@Input(NEWS_LETTER_SUBSCRIPTION_IN)
	SubscribableChannel newsLetterSubscriptionIn();
}