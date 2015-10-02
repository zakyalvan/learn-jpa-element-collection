package com.jakartawebs.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(LearningApplication.class);
	
	public static void main(String[] args) {
		new SpringApplication(LearningApplication.class).run(args);
	}
}
