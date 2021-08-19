package com.eresh.outbox.user.outbox;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Data
@NoArgsConstructor
public class OutboxEvent {
	private String aggregateName;
	private String aggregateId;
	private String eventType;
	private String eventName;
	private JsonNode payload;
}