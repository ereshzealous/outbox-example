package com.eresh.outbox.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class UpdateEmailDTO {
	@Email(message = "Invalid email format")
	private String email;
}