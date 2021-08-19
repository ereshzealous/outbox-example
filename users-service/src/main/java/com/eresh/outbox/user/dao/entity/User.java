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
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
}