package com.rays.lifecycle;

public class MyBean {

	public void init() {
		System.out.println("init method call: before bean creation");
	}

	public void destroy() {
		System.out.println("destroy method call: after bean destroy");
	}
}