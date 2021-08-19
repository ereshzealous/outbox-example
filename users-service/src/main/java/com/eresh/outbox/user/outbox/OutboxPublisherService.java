package com.eresh.outbox.user.outbox;

import com.eresh.outbox.user.dao.entity.Outbox;
import com.eresh.outbox.user.dao.repository.OutboxRepository;
import com.eresh.outbox.user.util.DTOConversionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class OutboxPublisherService {
	private final OutboxRepository outboxRepository;

	@EventListener
	public void handleOutboxEvent(OutboxEvent event) {

		UUID uuid = UUID.randomUUID();
		Outbox outbox = DTOConversionUtil.fromOutboxEvent(event);
		outbox.setId(uuid.toString());
		outbox.setCreatedOn(LocalDateTime.now());
		log.info("Handling event : {}.", outbox);

		outboxRepository.save(outbox);

		//outBoxRepository.delete(outbox);
	}
}