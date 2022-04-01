package com.pichincha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CbePracticalAssessmentJava2022Q1Application {

	public static void main(String[] args) {
		SpringApplication.run(CbePracticalAssessmentJava2022Q1Application.class, args);
	}

}
