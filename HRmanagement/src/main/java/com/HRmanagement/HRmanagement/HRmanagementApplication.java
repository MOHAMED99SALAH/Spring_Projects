package com.HRmanagement.HRmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class HRmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRmanagementApplication.class, args);
	}

}
