package com.learning.queues;

import java.util.Scanner;

public class StackImplementionUsingTwoQueues {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();

		System.out.println("Stack using two Queues... \n");
		char ch;
		do {
			System.out.println("Stack Operations...");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Integer element to push");
				stackUsingTwoQueues.push(scanner.nextInt());
				break;
			case 2:
				try {
					System.out.println("Poppped Element is : " + stackUsingTwoQueues.pop());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break; 
			default:
				System.out.println("Please Select a valid option!");
				break;
			}
			
			stackUsingTwoQueues.display();
			System.out.println("Do you want to continue ? (Type Y or N) \n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		
		scanner.close();
	}

}
