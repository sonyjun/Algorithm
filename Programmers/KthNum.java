package Programmers;

import java.util.Arrays;

public class KthNum {
	public static void main(String[] args) {
		int[] answer = solution(new int[] { 1, 5, 2, 6, 3, 7, 4 },
				new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });
		for (int i : answer) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int index = 0;
		for (int i = 0; i < commands.length; i++) {
			int[] tempArr = new int[commands[i][1] - commands[i][0] + 1];
			int t = 0;
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				tempArr[t++] = array[j];
			}
			Arrays.sort(tempArr);
			answer[index++] = tempArr[commands[i][2] - 1];
		}

		return answer;
	}
}
