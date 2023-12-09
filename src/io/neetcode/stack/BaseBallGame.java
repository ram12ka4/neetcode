package io.neetcode.stack;

import java.util.Stack;

public class BaseBallGame {

	public int calPoints(String[] operations) {

		Stack<Integer> stack = new Stack<Integer>();

		for (String op : operations) {

			if (op.equals("+") && stack.size() >= 2) {
				int score1 = stack.pop();
				int score2 = stack.peek();
				int score3 = score1 + score2;
				stack.push(score1);
				stack.push(score3);
			} else if (op.equals("D") && !stack.isEmpty()) {
				int score1 = stack.peek();
				int score2 = score1 * 2;
				stack.push(score2);
			} else if (op.equals("C") && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.push(Integer.parseInt(op));
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}

	public static void main(String[] args) {
		String[] str = { "5", "2", "C", "D", "+" };
		BaseBallGame obj = new BaseBallGame();
		System.out.println(obj.calPoints(str));
	}

}
