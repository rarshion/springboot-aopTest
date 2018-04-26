package com.example.aop_inject_demo;


public class CGLibContainerDemo {
	
	public static void main(String[] args) {
		
		ServiceA a = CGLibContainer.getInstance(ServiceA.class);
		a.callB();
		
	}
}
