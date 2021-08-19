package com.eresh.outbox.user.util;

import com.eresh.outbox.user.dao.entity.Outbox;
import com.eresh.outbox.user.dao.entity.User;
import com.eresh.outbox.user.dto.CreateNewsLetterSubscriptionDTO;
import com.eresh.outbox.user.dto.CreateUserDTO;
import com.eresh.outbox.user.dto.OutboxDTO;
import com.eresh.outbox.user.dto.SubscriptionsEventDTO;
import com.eresh.outbox.user.dto.UserDTO;
import com.eresh.outbox.user.outbox.OutboxEvent;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DTOConversionUtil {

	public static UserDTO toUsersDTO(User user) {
		UserDTO usersDTO = new UserDTO();
		usersDTO.setEmail(user.getEmail());
		usersDTO.setCreatedAt(user.getCreatedAt());
		usersDTO.setFullName(user.getFullName());
		usersDTO.setId(user.getId());
		usersDTO.setGender(user.getGender());
		usersDTO.setMobileNumber(user.getMobileNumber());
		return usersDTO;
	}

	public static User toUsers(UserDTO usersDTO) {
		User users = new User();
		users.setEmail(usersDTO.getEmail());
		users.setCreatedAt(usersDTO.getCreatedAt());
		users.setFullName(usersDTO.getFullName());
		users.setId(usersDTO.getId());
		users.setMobileNumber(usersDTO.getMobileNumber());
		return users;
	}

	public static OutboxDTO toOutboxDTO(Outbox outbox) {
		OutboxDTO outboxDTO = new OutboxDTO();
		outboxDTO.setId(outbox.getId());
		outboxDTO.setAggregateId(outbox.getAggregateId());
		outboxDTO.setCreatedOn(outbox.getCreatedOn());
		outboxDTO.setEventType(outbox.getEventType());
		outboxDTO.setPayload(outbox.getPayload());
		return outboxDTO;
	}

	public static Outbox toOutbox(OutboxDTO outboxDTO) {
		Outbox outbox = new Outbox();
		outbox.setId(outboxDTO.getId());
		outbox.setAggregateId(outboxDTO.getAggregateId());
		outbox.setCreatedOn(outboxDTO.getCreatedOn());
		outbox.setEventType(outboxDTO.getEventType());
		outbox.setPayload(outboxDTO.getPayload());
		return outbox;
	}

	public static User toUsers(CreateUserDTO dto) {
		User users = new User();
		users.setGender(dto.getGender());
		users.setFullName(dto.getFullName());
		users.setMobileNumber(dto.getMobileNumber());
		users.setEmail(dto.getEmail());
		users.setCreatedAt(LocalDateTime.now());
		return users;
	}

	public static Outbox fromOutboxEvent(OutboxEvent event) {
		Outbox outbox = new Outbox();
		outbox.setAggregateId(event.getAggregateId());
		outbox.setEventType(event.getEventType());
		outbox.setPayload(event.getPayload().toPrettyString());
		outbox.setAggregateName(event.getAggregateName());
		outbox.setEventName(event.getEventName());
		return outbox;
	}

	public static OutboxEvent toOutboxEvent(String aggregateId, String eventType, JsonNode payload, String eventName, String aggregate) {
		OutboxEvent event = new OutboxEvent();
		event.setEventType(eventType);
		event.setPayload(payload);
		event.setAggregateId(aggregateId);
		event.setEventName(eventName);
		event.setAggregateName(aggregate);
		return event;
	}

	public static SubscriptionsEventDTO subscriptionsEventDTO(User user, CreateNewsLetterSubscriptionDTO subscriptionDTO) {
		SubscriptionsEventDTO dto = new SubscriptionsEventDTO();
		dto.setSubscriptions(subscriptionDTO.getSubscriptions());
		dto.setEmail(user.getEmail());
		dto.setUserId(user.getId());
		return dto;
	}
}