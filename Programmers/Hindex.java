package Programmers;

import java.util.Arrays;

public class Hindex {
	public static void main(String[] args) {
		// System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(solution(new int[] { 12, 11, 10, 9, 8, 1 }));
		System.out.println(solution(new int[] { 6, 6, 6, 6, 6, 1 }));
		System.out.println(solution(new int[] { 4, 4, 4 }));
		System.out.println(solution(new int[] { 4, 4, 4, 5, 0, 1, 2, 3 }));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int temp = 0;
		for (int i = 0; i < citations.length; i++) {//
			// i번째 수부터 검사를 시작. 포함이 가능한지 확인. 포함이 안되는 구간까지 ㄱㄱ.
			if (citations[i] > citations.length - i) {
				for (int j = citations[i]; j >= 0; j--) {
					if (j <= citations.length - i) {
						temp = j;
						return Math.max(answer, temp);
					}
				}
			} else {
				answer = citations[i];
			}
		}
		return answer;
	}
}
