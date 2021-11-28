package com.great.learning.model;

public class Customer {

	private String bankAccountNo;
	private String password;

	public Customer(String bankAccountNumber, String pwd) {
		this.bankAccountNo = bankAccountNumber;
		this.password = pwd;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public String getPassword() {
		return password;
	}
}
