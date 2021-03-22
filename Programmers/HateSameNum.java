package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class HateSameNum {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[] { 1, 1, 3, 3, 0, 1, 1 });
		int[] answer2 = solution(new int[] { 4, 4, 4, 3, 3 });
	}

	public static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);
		}

		while (!stack.isEmpty()) {
			int popNum = stack.pop();
			while (true) {
				if (!stack.isEmpty() && stack.peek() == popNum) {
					stack.pop();
				} else {
					break;
				}
			}
			answerList.add(popNum);
		}
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(answerList.size() - i - 1);
		}
		return answer;
	}
}
