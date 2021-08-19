package com.eresh.outbox.user.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Topics {

	NEW_USER_CREATED("new_user"),
	USER_SUBSCRIBED_TO_NEWS_LETTERS("news_letter_subscription"),
	EMAIL_CHANGED("email_changed");

	private String topic;
}