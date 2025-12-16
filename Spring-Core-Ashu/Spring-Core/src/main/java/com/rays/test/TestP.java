package com.rays.test;

public class TestP {

	public static void main(String[] args) {

		Person p = new Person();

		p.setAddress("Indore");
		p.setName("Ram");

		System.out.println(p.getName());
		System.out.println(p.getAddress());

		System.out.println("-------");

		Person p1 = new Person("Shyam", "Bhopal");

		System.out.println(p1.getName());
		System.out.println(p1.getAddress());

	}

}
