package com.learning.queues;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingTwoQueues {

	Queue<Integer> queue;
	Queue<Integer> tempQueue;

	public StackUsingTwoQueues() {
		queue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}

	public void push(int data) {

		// if no element is present in the queue, then add the element to the queue.
		if (queue.isEmpty()) {
			queue.add(data);
		} else {

			// if elements are present in the queue,
			// 1. Remove all the elements from queue
			// 2. Move them to tempQueue

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Integer element = queue.remove();
				tempQueue.add(element);
			}

			// 3. Add the new element to the queue
			queue.add(data);

			// 4. Bring back all the element from tempQueue to main Queue
			for (int i = 0; i < size; i++) {
				Integer element = tempQueue.remove();
				queue.add(element);
			}
		}
	}

	public int pop() {
		if (queue.size() == 0) {
			throw new NoSuchElementException("Underflow");
		}
		return queue.remove();
	}
	
	
	public void display() {
		
		System.out.print("Stack contents are : ");
		int size = queue.size();
		
		if(size == 0) {
			System.out.println("Empty\n");
		} else {
			for(Integer eachElement : queue) {
				System.out.print(eachElement + " ");
			}
		}
		System.out.println("\n");
	}
}
