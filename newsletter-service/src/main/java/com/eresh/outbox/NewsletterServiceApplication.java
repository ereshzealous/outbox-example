package com.eresh.outbox;

import com.eresh.outbox.kafka.EmailChangedBindings;
import com.eresh.outbox.kafka.NewUserBindings;
import com.eresh.outbox.kafka.NewsLetterSubscriptionBindings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(value = {NewUserBindings.class, EmailChangedBindings.class, NewsLetterSubscriptionBindings.class})
public class NewsletterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsletterServiceApplication.class, args);
	}

}
