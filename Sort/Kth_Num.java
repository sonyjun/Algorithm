package Sort;

import java.util.Arrays;

public class Kth_Num {
	public static void main(String args[]) {
		Kth_Num_Solution s = new Kth_Num_Solution();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		s.solution(array, commands);
	}
}

class Kth_Num_Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int answerIndex = 0;
		for (int i = 0; i < commands.length; i++) {
			// [i][0] -> 시작지점
			// [i][1] -> 끝나는지점
			// [i][2] -> 몇번째꺼
			int arraySize = (commands[i][1] - commands[i][0] + 1);
			int tempArrayIndex = 0;
			int[] tempArray = new int[arraySize];
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				tempArray[tempArrayIndex++] = array[j];
			}
			Arrays.sort(tempArray);
			answer[answerIndex++] = tempArray[commands[i][2]-1];
		}
		return answer;
	}
}