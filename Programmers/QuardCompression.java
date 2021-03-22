package Programmers;

public class QuardCompression {
	static int[][] staticArr;
	static int zero = 0;
	static int one = 0;

	public static void main(String[] args) {
		//int[] answer1 = solution(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } });
		int[] answer2 = solution(new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } });
	}

	public static int[] solution(int[][] arr) {
		staticArr = arr;
		compression(0, 0, arr.length);
		int[] answer = { zero, one };
		System.out.println(zero);
		System.out.println(one);
		return answer;
	}

	public static void compression(int startI, int startJ, int size) {
		System.out.println(startI + "," + startJ);
		int num = staticArr[startI][startJ];
		if (size == 1) {
			if (num == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}
		for (int i = startI; i < startI + size; i++) {
			for (int j = startJ; j < startJ + size; j++) {
				if (num != staticArr[i][j]) {// 다른게 발견되었다면 압축가야지.
					compression(startI, startJ, size / 2);
					compression(startI + size / 2, startJ, size / 2);
					compression(startI, startJ + size / 2, size / 2);
					compression(startI + size / 2, startJ + size / 2, size / 2);
					return;
				}
			}
		}
		if (num == 0) {
			zero++;
		} else {
			one++;
		}
	}
}
