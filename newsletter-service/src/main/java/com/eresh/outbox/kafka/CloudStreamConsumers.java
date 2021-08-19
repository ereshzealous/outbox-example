package com.eresh.outbox.kafka;

import com.eresh.outbox.mongo.service.NewsLetterSubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class CloudStreamConsumers {

	private final NewsLetterSubscriptionService newsLetterSubscriptionService;

	@SneakyThrows
	@StreamListener(NewUserBindings.NEW_USER_IN)
	public void consumeNewUserEvent(@Payload String data) {
		log.info("Received Message from new_user topic --->" + data);
		newsLetterSubscriptionService.createNewUserSubscriptions(data);
	}

	@SneakyThrows
	@StreamListener(EmailChangedBindings.EMAIL_CHANGED_IN)
	public void consumeEmailUpdatedEvent(String data) {
		log.info("Received Message from email_changed topic --->" + data);
		newsLetterSubscriptionService.updateEmailForUser(data);
	}

	@SneakyThrows
	@StreamListener(NewsLetterSubscriptionBindings.NEWS_LETTER_SUBSCRIPTION_IN)
	public void consumeNewsLetterSubscriptionsEvent(String data) {
		log.info("Received Message from news_letter_subscription topic --->" + data);
		newsLetterSubscriptionService.createNewsLetterSubscriptions(data);
	}

	/*@StreamListener( = "input", target = "new_user")
	public void consumeNewUserEvent(String data) throws Exception {
		log.info("Received Message from new_user topic --->" + data);
		newsLetterSubscriptionService.createNewUserSubscriptions(data);
	}

	@StreamListener(value = "input", target = "news_letter_subscription")
	public void consumeNewsLetterSubscriptionsEvent(String data) throws Exception {
		log.info("Received Message from news_letter_subscription topic --->" + data);
		newsLetterSubscriptionService.createNewsLetterSubscriptions(data);
	}


	@StreamListener(value = "input", target = "email_changed")
	public void consumeEmailUpdatedEvent(String data) throws Exception {
		log.info("Received Message from email_changed topic --->" + data);
		newsLetterSubscriptionService.updateEmailForUser(data);
	}*/
}