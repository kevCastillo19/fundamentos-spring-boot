package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanDependencyImplement implements MyBeanWithDependency {

	private MyOperation myOperation;
	
	
	
	public MyBeanDependencyImplement(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}



	@Override
	public void printWithDependency() {
		int number = 1;
		System.out.println("Hola desde un bean con depenedencia");
		System.out.println(myOperation.sum(number));
	}
	
}
