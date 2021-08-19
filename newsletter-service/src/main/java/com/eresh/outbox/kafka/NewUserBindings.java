package com.eresh.outbox.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
public interface NewUserBindings {
	String NEW_USER_IN = "new-user-in";

	@Input(NEW_USER_IN)
	SubscribableChannel newUserIn();
}