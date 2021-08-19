package com.eresh.outbox.mongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Document(collection = "newsLetterSubscription")
@Data
@Builder
public class NewsLetterSubscription {

	@Id
	private String id;
	private String userId;
	private String newsLetter;
	private String frequency;
	private String email;
	private LocalDateTime createdOn;
}