package com.eresh.outbox.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Data
@NoArgsConstructor
public class OutboxDTO {
	private String id;
	private String aggregateId;
	private String eventType;
	private String payload;
	private LocalDateTime createdOn;
}