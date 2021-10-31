package com.fundamentos.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding //Para que se construya el pojo a partir de las propiedades
@ConfigurationProperties(prefix = "user")
public class UsePojo {
	private String email;
	private String password;
	private int edad;
	public UsePojo(String email, String password, int edad) {
		super();
		this.email = email;
		this.password = password;
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
