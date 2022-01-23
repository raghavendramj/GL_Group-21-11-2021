package com.learning.queues;

public class LinkedListExample {
	
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node reverseList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		return head;
	}

	public static void printList(Node node) {

		System.out.println("\nElements in the List are ... ");
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		printList(head);

		Node revesedNode = reverseList(head);
		System.out.println("Reversed List is  ");
		printList(revesedNode);

	}

}
