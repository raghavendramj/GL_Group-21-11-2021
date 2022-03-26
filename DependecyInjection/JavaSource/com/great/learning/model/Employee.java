package com.great.learning.model;

public class Employee {
	private int id;
	private String name;
	private Address address;

	//Constructor Injection.
	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}