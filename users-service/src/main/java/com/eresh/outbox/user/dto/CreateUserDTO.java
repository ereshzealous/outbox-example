package com.eresh.outbox.user.dto;

import lombok.Data;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class CreateUserDTO {
	private String fullName;
	private String email;
	private String mobileNumber;
	private String gender;
}