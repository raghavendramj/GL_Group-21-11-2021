package com.great.learning.client;

import com.great.learning.model.Address;
import com.great.learning.model.Employee;

public class ClientCode {
	public static void main(String[] args) {
		Address address = new Address("Bangalore", "KA", "IN");
		Employee employee = new Employee(1, "Raghav", address);
		System.out.println("Employee " + employee);
	}
}
