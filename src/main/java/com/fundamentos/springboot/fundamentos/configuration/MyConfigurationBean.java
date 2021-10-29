package com.fundamentos.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.fundamentos.bean.*;

@Configuration
public class MyConfigurationBean {
	@Bean
	public MyBean beanOperation() {
		return new MyBeanImplement2();
	}
	
	@Bean
	public MyOperation beanOperationNumber() {
		return new MyOperationImplement();
	}
	
	@Bean
	public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
		return new MyBeanDependencyImplement(myOperation);
	}
}
