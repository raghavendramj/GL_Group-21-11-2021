package com.greatlearning.driver;

import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialService;

public class EmailDriver {
	public static void main(String[] args) {

		// Employee object creation -> Dummy Object
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to GreatLearning, Lets generate your credentails for you!");
		System.out.println("Please Enter your firstName : ");
		String firstName = scanner.nextLine();
		System.out.println("Please Enter your lastName : ");
		String lastName = scanner.nextLine();

		System.out.println("Please enter the department from the following ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");

		int option = scanner.nextInt();
		scanner.close();

		String departmentName = "";
		switch (option) {

		case 1:
			departmentName = Department.TECH.toString().toLowerCase();
			break;

		case 2:
			departmentName = "admin";
			break;

		case 3:
			departmentName = "hr";
			break;

		case 4:
			departmentName = "lgl";
			break;

		default:
			System.out.println("Please enter valid option");
		}

		Employee employeeObject = new Employee(firstName, lastName);
		CredentialService credentialService = new CredentialService();

		String modifiedFirstName = employeeObject.getFirstName().trim().toLowerCase();

		String modifiedLastName = employeeObject.getLastName().replace(" ", "");
		modifiedLastName = modifiedLastName.trim().toLowerCase();

		String genratedEmail = credentialService.generateEmailAddress(modifiedFirstName, modifiedLastName,
				departmentName);
		String generatedPassword = credentialService.generatePassword();
		credentialService.showCredentials(employeeObject, genratedEmail, generatedPassword);

	}

}
