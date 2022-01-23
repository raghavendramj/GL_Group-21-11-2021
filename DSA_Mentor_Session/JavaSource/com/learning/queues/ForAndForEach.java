package com.learning.queues;

public class ForAndForEach {

	public static void main(String[] args) {
		int array[] = { 3, 4, 1, 5, 7 };

		for (int i = 0; i < array.length; i++) {
			int element = array[i];
			System.out.println("Using for i loop element :- " + element);

		}

		System.out.println("\nFor Each Loop");

		for (Integer puneeth : array) {
			System.out.println("Using for each loop element :- " + puneeth);
		}

	}

}
