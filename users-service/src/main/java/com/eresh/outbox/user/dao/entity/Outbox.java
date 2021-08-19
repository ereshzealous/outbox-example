package com.eresh.outbox.user.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Entity
@Table(name = "outbox")
@Data
@NoArgsConstructor
public class Outbox {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "aggregate_id")
	private String aggregateId;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "payload")
	private String payload;

	@Column(name = "aggregate_name")
	private String aggregateName;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "created_on", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;

}