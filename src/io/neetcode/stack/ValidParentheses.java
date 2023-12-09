package io.neetcode.stack;

import java.util.Stack;


/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:

    	Open brackets must be closed by the same type of brackets.
    	Open brackets must be closed in the correct order.
    	Every close bracket has a corresponding open bracket of the same type.
 */

public class ValidParentheses {

	public boolean isValid(String s) {

		if (s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
				return false;
			} else {
				if (s.charAt(i) == ')' && stack.peek() == '(')
					stack.pop();
				else if (s.charAt(i) == ']' && stack.peek() == '[')
					stack.pop();
				else if (s.charAt(i) == '}' && stack.peek() == '{')
					stack.pop();
				else
					stack.push(s.charAt(i));
			}
		}

		return stack.isEmpty();

	}

	public static void main(String[] args) {
		String str = "([}]";
		ValidParentheses obj = new ValidParentheses();
		System.out.println(obj.isValid(str));
	}

}
