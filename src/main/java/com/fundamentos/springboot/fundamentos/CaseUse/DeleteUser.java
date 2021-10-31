package com.fundamentos.springboot.fundamentos.CaseUse;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.fundamentos.services.UserService;

@Component
public class DeleteUser {
	private UserService userService;

	public DeleteUser(UserService userService) {
		super();
		this.userService = userService;
	}

	public void delete(Long id) {
		userService.delete(id);
	}
}
