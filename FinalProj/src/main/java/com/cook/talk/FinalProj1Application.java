package com.cook.talk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class FinalProj1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProj1Application.class, args);
	}
	
}
