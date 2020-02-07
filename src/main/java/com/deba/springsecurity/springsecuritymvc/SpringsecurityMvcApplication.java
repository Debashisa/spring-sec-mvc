package com.deba.springsecurity.springsecuritymvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringsecurityMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityMvcApplication.class, args);
	}

}
