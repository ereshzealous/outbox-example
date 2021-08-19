package com.eresh.outbox.mongo.repository;

import com.eresh.outbox.mongo.model.NewsLetterSubscription;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Repository
public interface NewsLetterSubscriptionRepository extends MongoRepository<NewsLetterSubscription, String> {
	List<NewsLetterSubscription> findByUserId(String userId);
}