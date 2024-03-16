package com.rgb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class SpringBootHexagonalKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHexagonalKafkaApplication.class, args);
	}

}
