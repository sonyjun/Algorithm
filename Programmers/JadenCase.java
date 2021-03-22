package Programmers;

import java.util.Stack;

public class JadenCase {
	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("aaaaa     aaa"));
	}

	public static String solution(String s) {
		Stack<String> stack = new Stack<String>();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			stack.add(s.charAt(i) + "");
		}
		String answer = "";
		while (!stack.isEmpty()) {
			String temp = stack.pop();
			if (!stack.isEmpty()) {
				if (stack.peek().equals(" ")) {
					answer = temp.toUpperCase() + answer;
				} else {
					answer = temp + answer;
				}
			} else {
				answer = temp.toUpperCase() + answer;
			}
		}
		return answer;
	}
}
