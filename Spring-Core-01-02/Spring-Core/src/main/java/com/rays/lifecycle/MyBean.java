package com.rays.lifecycle;

public class MyBean {

	public void start() {
		System.out.println("init method...");
	}

	public void cleanup() {
		System.out.println("destroy method...");
	}

}
