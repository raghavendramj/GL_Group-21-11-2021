package com.great.learning.main;

import java.util.Scanner;

import com.great.learning.model.Customer;
import com.great.learning.service.Banking;

public class BankDriverClass {

	public static void main(String[] args) {

		Banking banking = new Banking();
		Customer johnDoe = new Customer("56312795", "doejohn");

		Scanner scanner = new Scanner(System.in);

		String bankAccountNo;
		String password;
		System.out.println("Welcome to our XYZ Bank, Please login to continue!");
		System.out.println();

		System.out.println("Please Enter your Bank Account Number : ");
		bankAccountNo = scanner.nextLine();

		System.out.println("Please enter the password corresponding to the bank account no");
		password = scanner.nextLine();

		boolean isBankAccountNumberMatching = johnDoe.getBankAccountNo().equals(bankAccountNo);
		boolean isMatchingPassword = johnDoe.getPassword().equals(password);

		if (isBankAccountNumberMatching && isMatchingPassword) {
			System.out.println();
			System.out.println();
			System.out.println("Hey User, Welcome to the Bank!!");

			int option;
			do {

				System.out.println();
				System.out.println("-------------------------------------------------");
				System.out.println("Enter the operation that you want to perform : ");
				System.out.println("1. Deposit");
				System.out.println("2. Withdrawl");
				System.out.println("3. Transfer");
				System.out.println("4. Logout");
				System.out.println("-------------------------------------------------");

				option = scanner.nextInt();

				switch (option) {

				case 4:
					option = 4;
					break;

				case 1:
					banking.deposit();
					break;

				case 2:
					banking.withdrawl();
					break;

				case 3:
					banking.transfer();
					break;

				default:
					System.out.println("Please enter the Valid Operation!");
				}
			} while (option != 4);
			
			System.out.println("\n********* Logged Out Successfully! ********* ");
			scanner.close();
		} else {
			System.out.println("Invalid Credentials!");
		}
	}
}
