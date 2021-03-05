package Programmers;

public class TriangleSnail {
	public static void main(String[] args) {
		int[] answer1 = solution(4);
		for (int i : answer1) {
			System.out.print(i + " ");
		}
		System.out.println();

		int[] answer2 = solution(5);
		for (int i : answer2) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] answer3 = solution(6);
		for (int i : answer3) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	public static int[] solution(int n) {

		int[][] triangleArr = new int[n][n];
		int currentI = -1;
		int currentJ = 0;
		int num = 1;
		for (int i = n; i >= 1;) {// 출력해야되는 숫자의 수.
			// 1번의 경우(수직하게 아래로 내려옴)
			for (int t = 0; t < i; t++) {
				currentI += 1;
				triangleArr[currentI][currentJ] = num++;
			}
			i--;
			if (i < 1)
				break;

			// 2번의 경우(수평하게 오른쪽으로 감)
			for (int t = 0; t < i; t++) {
				currentJ += 1;
				triangleArr[currentI][currentJ] = num++;
			}
			i--;
			if (i < 1)
				break;

			// 3번의 경우(왼쪽 대각선으로 올라감)
			for (int t = 0; t < i; t++) {
				currentI -= 1;
				currentJ -= 1;
				triangleArr[currentI][currentJ] = num++;
			}
			i--;
			if (i < 1)
				break;

		}

		int[] answer = new int[n * (n + 1) / 2];
		int index = 0;
		for (int b = 0; b < triangleArr.length; b++) {
			for (int h = 0; h < b + 1; h++) {
				answer[index++] = triangleArr[b][h];
			}
		}
		return answer;
	}
}
