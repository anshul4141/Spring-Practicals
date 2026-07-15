package com.rays.test;

public class Employee {

	private String name;
	private String company;
	private int salary;

	public Employee() {

	}

	public Employee(String name, String company, int salary) {
		this.name = name;
		this.company = company;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "name: " + name + " company: " + company + " salary: " + salary;
	}
}
