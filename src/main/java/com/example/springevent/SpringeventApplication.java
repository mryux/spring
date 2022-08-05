package com.example.springevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringeventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeventApplication.class, args);
	}

}
