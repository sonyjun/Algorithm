package Programmers;

import java.util.Iterator;
import java.util.TreeSet;

public class ChooseTwoAndPlus {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 4, 1 }));
		System.out.println(solution(new int[] { 5, 0, 2, 7 }));
	}

	public static int[] solution(int[] numbers) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 0; i < numbers.length - 1; i++) {// i번째 숫자
			for (int j = i + 1; j < numbers.length; j++) {// i다음번째 숫자부터 끝까지.
				ts.add(numbers[i] + numbers[j]);
			}
		}
		int[] answer = new int[ts.size()];
		int index = 0;
		Iterator<Integer> iter = ts.iterator();
		while (iter.hasNext()) {
			answer[index++] = iter.next();
		}
		return answer;
	}
}
