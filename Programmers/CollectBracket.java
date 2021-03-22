package Programmers;

import java.util.Stack;

public class CollectBracket {
	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}

	static boolean solution(String s) {
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (leftCount == 0) {
					return false;
				} else {
					leftCount--;
				}
			} else {
				leftCount++;
			}
		}
		if (leftCount > 0) {
			return false;
		}else {
			return true;
		}
	}
}
