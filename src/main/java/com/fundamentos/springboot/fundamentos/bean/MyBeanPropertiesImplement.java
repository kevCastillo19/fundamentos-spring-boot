package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanPropertiesImplement implements MyBeanProperties {

	private String name;
	private String apellido;
	
	public MyBeanPropertiesImplement(String name, String apellido) {
		super();
		this.name = name;
		this.apellido = apellido;
	}

	@Override
	public String function() {
		return name + " " + apellido;
	}

}
