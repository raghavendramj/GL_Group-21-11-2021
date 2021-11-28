package com.great.learning.service;

import java.util.Scanner;

public class Banking {

	int bankBalance = 1000;
	Scanner scanner = new Scanner(System.in);
	OTPGenerator otpGenerator = new OTPGenerator();

	public void deposit() {
		int amount;
		System.out.println("Please enter the amount you want to deposit : ");
		amount = scanner.nextInt();

		if (amount > 0) {
			System.out.println("Amount : " + amount + " deposited successfully!");
			bankBalance = bankBalance + amount;
			// bankBalance += amount
			System.out.println("Updated bank balance is : " + bankBalance);
		} else {
			System.out.println("Please enter the correct amount!");
		}
	}

	public void withdrawl() {
		int amount;
		System.out.println("Enter the amount you want to withdrawl");
		amount = scanner.nextInt();

		if (bankBalance - amount >= 0) {
			System.out.println("Amount : " + amount + " withdrawn successfully!");
			bankBalance = bankBalance - amount;
			System.out.println("Remaining bank balance is : " + bankBalance);
		} else {
			System.out.println("Insufficent Funds!");
		}
	}

	public void transfer() {

		int amount;
		int otpGenerated;
		int userEnteredOTP;
		int toBeTransferredBankAccountNo;

		System.out.println("Please enter the OTP :");
		otpGenerated = otpGenerator.generateOTP();
		
		System.out.println("OTP generated : " + otpGenerated);
		userEnteredOTP = scanner.nextInt();

		if (userEnteredOTP == otpGenerated) {
			System.out.println("OTP verification successful!");
			System.out.println("Enter the amount and bank account number to which you want to transfer");
			amount = scanner.nextInt();
			toBeTransferredBankAccountNo = scanner.nextInt();

			if (bankBalance - amount >= 0) {
				System.out.println("Amount : " + amount + " transferred successfuly to the bankAccount " + toBeTransferredBankAccountNo);
				bankBalance = bankBalance - amount;
				System.out.println("Remaining bank balance is : " + bankBalance);
			} else {
				System.out.println("Insufficient Funds!");
			}

		} else {
			System.out.println("Invalid OTP, Please try again!");
		}

	}

}
