package com.great.learning.main;

interface TestInterface {
	int add(int a, int b);

	int subtract(int a, int b);
}

abstract class RBIBank {
	void withdraw() {
		System.out.println("Withdrawn successfully!");
	}

	public abstract void deposit();

	public abstract void transfer();
}

class ICICI extends RBIBank {

	@Override
	public void deposit() {
		
	}

	@Override
	public void transfer() {
		
	}
}

public class AbstractionTest {

}
