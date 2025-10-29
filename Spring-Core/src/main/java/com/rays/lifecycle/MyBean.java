package com.rays.lifecycle;

public class MyBean {

	public void init() {
		System.out.println("init method: bean created");
	}
	
	 public void service() {
	        System.out.println("service method called: (manually)");
	    }

	public void destroy() {
		System.out.println("destroy method: bean destroyed");
	}
}