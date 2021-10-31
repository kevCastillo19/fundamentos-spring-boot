package com.fundamentos.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.fundamentos.CaseUse.GetUser;
import com.fundamentos.springboot.fundamentos.CaseUse.GetUserImplement;
import com.fundamentos.springboot.fundamentos.services.UserService;

@Configuration
public class CaseUserConfiguration {
	
	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}
}
