package Sort;

import java.util.Arrays;

public class H_index {
	public static void main(String args[]) {
		H_indexSolution h = new H_indexSolution();
		int[] citations1 = { 3, 0, 6, 1, 5 };

		int[] citations2 = { 0, 1, 1, 1, 1, 3, 3, 4 };
		System.out.println(h.solution(citations1));
		System.out.println(h.solution(citations2));
	}
}

class H_indexSolution {
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = 0; i < citations[citations.length - 1]; i++) {// 최소와 최대값의 범위로 설정.
			for (int j = 0; j < citations.length; j++) {
				if (i <= citations[j]) {
					if (j <= i && i <= citations.length - j) {
						answer = i;
					}
					break;
				}
			}
		}
		return answer;
	}
}