package com.fundamentos.springboot.fundamentos.CaseUse;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.services.UserService;

@Component
public class CreateUser {
	private UserService userService;

	public CreateUser(UserService userService) {
		super();
		this.userService = userService;
	}

	public User save(User newUser) {
		return userService.save(newUser);
	}
}
