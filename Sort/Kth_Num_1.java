package Sort;

import java.util.Arrays;

public class Kth_Num_1 {
	public static void main(String args[]) {
		Kth_Num_Solution_1 s = new Kth_Num_Solution_1();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		s.solution(array, commands);
	}
}

class Kth_Num_Solution_1 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(tempArray);
			answer[i] = tempArray[commands[i][2]-1];
		}
		return answer;
	}
}