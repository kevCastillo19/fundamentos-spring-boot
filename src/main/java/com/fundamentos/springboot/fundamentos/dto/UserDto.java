package com.fundamentos.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {
	private Long id;
	private String name;
	private LocalDate birthDate;
	
	public UserDto(Long id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
