package com.eresh.outbox.user.outbox;

import com.eresh.outbox.user.dto.CreateNewsLetterSubscriptionDTO;
import com.eresh.outbox.user.dto.SubscriptionsEventDTO;
import com.eresh.outbox.user.dto.UserDTO;
import com.eresh.outbox.user.util.AggregateName;
import com.eresh.outbox.user.util.DTOConversionUtil;
import com.eresh.outbox.user.util.EventType;
import com.eresh.outbox.user.util.Topics;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OutboxEventsUtil {

	public static OutboxEvent createNewUserEvent(UserDTO usersDTO) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		JsonNode jsonNode = mapper.convertValue(usersDTO, JsonNode.class);
		OutboxEvent event = DTOConversionUtil.toOutboxEvent(usersDTO.getId(), EventType.INSERT.getType(), jsonNode, Topics.NEW_USER_CREATED.getTopic(),
		                                                    AggregateName.USER.getAggregate());
		return event;
	}

	public static OutboxEvent createNewsletterSubscriptions(SubscriptionsEventDTO dto) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		JsonNode jsonNode = mapper.convertValue(dto, JsonNode.class);
		OutboxEvent event = DTOConversionUtil.toOutboxEvent(dto.getUserId(), EventType.INSERT.getType(), jsonNode,
		                                                    Topics.USER_SUBSCRIBED_TO_NEWS_LETTERS.getTopic(), AggregateName.USER.getAggregate());
		return event;
	}

	public static OutboxEvent createEmailUpdatedEvent(UserDTO usersDTO) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		JsonNode jsonNode = mapper.convertValue(usersDTO, JsonNode.class);
		OutboxEvent event = DTOConversionUtil.toOutboxEvent(usersDTO.getId(), EventType.UPDATE.getType(), jsonNode, Topics.EMAIL_CHANGED.getTopic(),
		                                                    AggregateName.USER.getAggregate());
		return event;
	}
}