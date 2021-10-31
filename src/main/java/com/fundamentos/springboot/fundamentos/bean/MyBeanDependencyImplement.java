package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanDependencyImplement implements MyBeanWithDependency {

	Log LOGGER = LogFactory.getLog(MyBeanDependencyImplement.class);
	
	private MyOperation myOperation;
	
	public MyBeanDependencyImplement(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}



	@Override
	public void printWithDependency() {
		LOGGER.info("Ingresamos al metodo with dependency");
		int number = 1;
		LOGGER.debug("El numero enviado como parametro a la dependencia e: " + number);
		System.out.println(myOperation.sum(number));
		System.out.println("Hola desde un bean con depenedencia");
		
	}
	
}
