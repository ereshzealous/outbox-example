package com.eresh.outbox.kafka;

import com.eresh.outbox.mongo.service.NewsLetterSubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Component("newUserConsumer")
@RequiredArgsConstructor
@Slf4j
public class NewUserConsumer implements Consumer<String> {

	private final NewsLetterSubscriptionService newsLetterSubscriptionService;

	@SneakyThrows
	@Override
	public void accept(String data) {
		log.info("Received Message from new_user topic --->" + data);
		newsLetterSubscriptionService.createNewUserSubscriptions(data);
	}
}