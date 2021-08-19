package com.eresh.outbox.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
public interface EmailChangedBindings {
	String EMAIL_CHANGED_IN = "email-changed-in";

	@Input(EMAIL_CHANGED_IN)
	SubscribableChannel emailChangedIn();
}