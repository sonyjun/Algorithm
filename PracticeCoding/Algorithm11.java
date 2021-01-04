package PracticeCoding;

public class Algorithm11 {
	public static void main(String args[]) {
		Solution11 s11 = new Solution11();
		int[][] input1 = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
		int[][] input2 = { { 1, 1 }, { 2, 2 }, { 1, 2 } };
		s11.solution(input1);
		s11.solution(input2);
	}
}

class Solution11 {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];
		answer[0] = v[0][0];
		answer[1] = v[0][1];

		if (answer[0] == v[1][0]) {
			answer[0] = v[2][0];
		}else {
			if(answer[0] == v[2][0]) {
				answer[0] = v[1][0];
			}
		}
		if (answer[1] == v[1][1]) {
			answer[1] = v[2][1];
		} else {
			if(answer[1] == v[2][1]) {
				answer[1] = v[1][1];
			}
		}
		return answer;
	}
}
