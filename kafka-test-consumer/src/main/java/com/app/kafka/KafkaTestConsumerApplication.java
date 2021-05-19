package com.app.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaTestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTestConsumerApplication.class, args);
		System.out.println("Hello Final consumer");
	}

}
