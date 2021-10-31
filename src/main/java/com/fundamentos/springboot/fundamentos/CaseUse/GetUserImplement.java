package com.fundamentos.springboot.fundamentos.CaseUse;

import java.util.List;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.services.UserService;

public class GetUserImplement implements GetUser {

	private UserService userService;
	
	public GetUserImplement(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List<User> getAll() {
		return userService.getAllUsers();
	}

}
