package Programmers;

import java.util.ArrayList;

public class MockTest {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[] { 6,6,6,6,6 });
		for(int i : answer1) {
			System.out.print(i+" ");
		}
		System.out.println();
		int[] answer2 = solution(new int[] { 1, 3, 2, 4, 2 });
	}

	public static int[] solution(int[] answers) {
		String pattern1 = "12345";
		String pattern2 = "21232425";
		String pattern3 = "3311224455";
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		// answers크기 만큼 늘려줘야함.
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == Integer.parseInt(pattern1.charAt(i % pattern1.length()) + "")) {
				count++;
			}
		}
		max = Math.max(max, count);
		answerList.add(count);
		count = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == Integer.parseInt(pattern2.charAt(i % pattern2.length()) + "")) {
				count++;
			}
		}
		max = Math.max(max, count);
		answerList.add(count);
		count = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == Integer.parseInt(pattern3.charAt(i % pattern3.length()) + "")) {
				count++;
			}
		}
		max = Math.max(max, count);
		//세명의 정답률을 구하고, 최대값이 무엇인기 기억해놓음.
		
		answerList.add(count);
		int index = 0;
		int[] temp = new int[3];
		for (int i = 0; i < answerList.size(); i++) {
			if (max == answerList.get(i)) {
				temp[index++] = i + 1;
			}
		}

		int[] answer = new int[index];
		for (int i = 0; i < index; i++) {
			answer[i] = temp[i];
		}
		return answer;
	}
}
