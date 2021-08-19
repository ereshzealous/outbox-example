package com.eresh.outbox.mongo.service;

import com.eresh.outbox.dto.NewsLetterSubscriptionDTO;
import com.eresh.outbox.dto.SubscriptionsEventDTO;
import com.eresh.outbox.mongo.model.NewsLetterSubscription;
import com.eresh.outbox.mongo.repository.NewsLetterSubscriptionRepository;
import com.eresh.outbox.util.NewsLetter;
import com.eresh.outbox.util.NewsLetterFrequencies;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Service
@RequiredArgsConstructor
public class NewsLetterSubscriptionService {

	private final NewsLetterSubscriptionRepository newsLetterSubscriptionRepository;
	private final ObjectMapper objectMapper;

	public void createNewUserSubscriptions(String message) throws Exception {
		JsonNode jsonNode = objectMapper.readTree(message);
		String payload = jsonNode.get("payload").textValue();
		jsonNode = objectMapper.readTree(payload);
		String userId = jsonNode.get("id").textValue();
		String email = jsonNode.get("email").textValue();
		newsLetterSubscriptionRepository.saveAll(getNewUserSubscriptions(userId, email));
	}

	public void createNewsLetterSubscriptions(String message) throws Exception {
		JsonNode jsonNode = objectMapper.readTree(message);
		String payload = jsonNode.get("payload").textValue();
		SubscriptionsEventDTO subscription = objectMapper.readValue(payload, SubscriptionsEventDTO.class);
		newsLetterSubscriptionRepository.saveAll(createNewsLetterSubscriptions(subscription));
	}

	public void updateEmailForUser(String message) throws Exception {
		JsonNode jsonNode = objectMapper.readTree(message);
		String payload = jsonNode.get("payload").textValue();
		jsonNode = objectMapper.readTree(payload);
		String email = jsonNode.get("email").asText();
		String userId = jsonNode.get("id").asText();
		List<NewsLetterSubscription> subscriptions = newsLetterSubscriptionRepository.findByUserId(userId);
		subscriptions = subscriptions.stream().map(data -> this.updateEmail(email, data)).collect(Collectors.toList());
		newsLetterSubscriptionRepository.saveAll(subscriptions);
	}

	private NewsLetterSubscription updateEmail(String email, NewsLetterSubscription subscription) {
		subscription.setEmail(email);
		return subscription;
	}

	private List<NewsLetterSubscription> getNewUserSubscriptions(String userId, String email) {
		return Stream.of(NewsLetterSubscription.builder()
		                                .userId(userId)
		                                       .createdOn(LocalDateTime.now())
		                                .frequency(NewsLetterFrequencies.WEEKLY.getFrequency())
		                                .newsLetter(NewsLetter.BEST_SELLERS.getNewsLetter())
		                                       .email(email)
		                                .build(),
		          NewsLetterSubscription.builder()
		                                .userId(userId)
		                                .frequency(NewsLetterFrequencies.MONTHLY.getFrequency())
		                                .createdOn(LocalDateTime.now())
		                                .email(email)
		                                .newsLetter(NewsLetter.HOT_KEYWORDS.getNewsLetter())
		                                .build()).collect(Collectors.toList());
	}

	private List<NewsLetterSubscription> createNewsLetterSubscriptions(SubscriptionsEventDTO dto) {
		List<NewsLetterSubscription> newsLetterSubscriptions = new ArrayList<>();
		for (NewsLetterSubscriptionDTO eventDTO : dto.getSubscriptions()) {
			newsLetterSubscriptions.add(toNewsLetterSubscription(dto.getUserId(), dto.getEmail(), eventDTO));
		}
		return newsLetterSubscriptions;
	}

	private NewsLetterSubscription toNewsLetterSubscription(String userId, String email, NewsLetterSubscriptionDTO dto) {
		return  NewsLetterSubscription.builder().newsLetter(dto.getNewsLetter())
		                              .frequency(dto.getFrequency())
		                              .email(email)
		                              .userId(userId)
		                              .createdOn(LocalDateTime.now())
		                              .build();
	}

}