package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
	@Override
	public void saludar() {
		System.out.print("Hola mundo desde mi primer component");
	}

}
