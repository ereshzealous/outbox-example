package com.eresh.outbox.user.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Data
public class CreateNewsLetterSubscriptionDTO {
	@NotBlank(message = "userId can not be left blank")
	private String userId;
	private List<@Valid NewsLetterSubscriptionDTO> subscriptions = Collections.emptyList();
}