package com.greatlearning;

import java.util.Stack;

public class BalancedBrackets {

	public static boolean isBalanced(String brackets) {

		int len = brackets.length();
		// Base Condition -> for odd numbered brackets
		if (len <= 0 || len % 2 != 0) {
			System.out.println("Case 0" + brackets);
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char currentChar = brackets.charAt(i);

			// For all incoming opening brackets, just push it.
			if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
				stack.push(currentChar);
			} else if (!stack.isEmpty()) {
				if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
					char top = stack.peek();
					boolean isParenthisis = top == '(' && currentChar == ')';
					boolean isFlower = top == '{' && currentChar == '}';
					boolean isSquare = top == '[' && currentChar == ']';

					if (isParenthisis || isFlower || isSquare) {
						stack.pop();
					} else {
						System.out.println("Case 1" + brackets);
						// Can be any opening bracket
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// System.out.println("Are these brackets are balanced : " +
		// isBalanced("([{}])"));
		// System.out.println("Are these brackets are balanced : " +
		// isBalanced("([{{])"));
		System.out.println("Are these brackets are balanced : " + isBalanced("((]]"));
		System.out.println("Are these brackets are balanced : " + isBalanced("(()[]{})"));
		System.out.println("Are these brackets are balanced : " + isBalanced("([{}])"));
		System.out.println("Are these brackets are balanced : " + isBalanced("([]{})"));
		System.out.println("Are these brackets are balanced : " + isBalanced("{([])}"));
		System.out.println("Are these brackets are balanced : " + isBalanced("{][)(}"));
		System.out.println("Are these brackets are balanced : " + isBalanced(")("));
		System.out.println("Are these brackets are balanced : " + isBalanced("({]})"));
		System.out.println("Are these brackets are balanced : " + isBalanced("([[{}]])"));
		System.out.println("Are these brackets are balanced : " + isBalanced("([[{}}])"));
		System.out.println("Are these brackets are balanced : " + isBalanced("()"));
		System.out.println("Are these brackets are balanced : " + isBalanced("(){}[]"));
		System.out.println("Are these brackets are balanced : " + isBalanced("({}]"));
		System.out.println("Are these brackets are balanced : " + isBalanced("("));
		System.out.println("Are these brackets are balanced : " + isBalanced(")["));
		System.out.println("Are these brackets are balanced : " + isBalanced("(((]"));
		System.out.println("Are these brackets are balanced : " + isBalanced(")))["));
		System.out.println("Are these brackets are balanced : " + isBalanced("]})["));
	}

}
