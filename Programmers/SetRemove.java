package Programmers;

import java.util.Stack;

public class SetRemove {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}

	public static int solution(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add((int) s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == (int) s.charAt(i)) {
				stack.pop();
			} else {
				stack.add((int) s.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			return 1;
		} else {
			return -1;
		}
	}
}
