package com.akash.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	/*
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	*/

	@Bean
	WebClient webClient(){
		return WebClient.builder().build();
	}


}
