package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.model.Employee;

public class CredentialService {

	/**
	 * Generates the new password
	 * @return
	 */
	public String generatePassword() {
		String generatedPassword = "";
		// -> number, capital letter, small letter & special character
		String numbers = "1234567890";
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTWXYZ";
		String smallLatters = "abcdefghijklmnopqrstwxyz";
		String specialCharacters = "!@#$%^&*()";

		String values = capitalLetters + smallLatters + numbers + specialCharacters;
		// ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz1234567890!@#$%^&*()

		Random randomize = new Random();
		char[] password = new char[8];

		int lengthOfValue = values.length(); // 72
		for (int i = 0; i < 8; i++) {
			int randomNextInteger = randomize.nextInt(lengthOfValue); // -> 0 - 72
			password[i] = values.charAt(randomNextInteger);
		}
		generatedPassword = password.toString();

		return generatedPassword;
	}

	/**
	 * Generates the Email address
	 * 
	 * @param firstName
	 * @param lastName
	 * @param departmentName
	 * @return generated email address
	 */

	public String generateEmailAddress(String firstName, String lastName, String departmentName) {
		// -> firstNamelastName@department.company.com
		String generatedEmailAddress = firstName + lastName + "@" + departmentName + ".greatlearning.com";
		return generatedEmailAddress;
	}

	/**
	 * Displays the Credentials of the user
	 * 
	 * @param employeeObject
	 * @param email
	 * @param generatedPassword
	 */
	public void showCredentials(Employee employeeObject, String email, String generatedPassword) {
		System.out.println("Dear " + employeeObject.getFirstName() + " you generated credentials are as follows");
		System.out.println("You generated Email Address is :" + email);
		System.out.println(" and password is " + generatedPassword);
	}
}
