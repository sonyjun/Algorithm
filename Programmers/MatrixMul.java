package Programmers;

public class MatrixMul {
	public static void main(String[] args) {
		int[][] answer1 = solution(new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 3, 3 }, { 3, 3 } });
		int[][] answer2 = solution(new int[][] { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } },
				new int[][] { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } });
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				for (int t = 0; t < arr1[0].length; t++) {
					answer[i][j] += arr1[i][t] * arr2[t][j];
				}
			}
		}

		return answer;
	}
}
