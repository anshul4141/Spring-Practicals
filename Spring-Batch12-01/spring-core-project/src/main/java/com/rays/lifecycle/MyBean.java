package com.rays.lifecycle;

public class MyBean {

	public void init() {
		System.out.println("init method: bean created");
	}

	public void destroy() {
		System.out.println("destroy method: bean destroied");
	}

}
