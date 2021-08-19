package com.eresh.outbox.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Data
@NoArgsConstructor
public class UserDTO {
	private String id;
	private String fullName;
	private String email;
	private String mobileNumber;
	private String gender;
	private LocalDateTime createdAt;
}