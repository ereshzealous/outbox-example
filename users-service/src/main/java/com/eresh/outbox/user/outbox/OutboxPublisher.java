package com.eresh.outbox.user.outbox;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Component
public class OutboxPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	public void publishEvent(OutboxEvent outboxEvent) {
		this.publisher.publishEvent(outboxEvent);
	}
}