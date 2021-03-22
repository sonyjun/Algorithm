package Programmers;

import java.util.Arrays;

public class GetLand {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 100 }, { 4, 3, 2, 1 } }));
		System.out.println(solution(new int[][] { { 4, 3, 2, 1 }, { 2, 2, 2, 1 }, { 6, 6, 6, 4 }, { 8, 7, 6, 5 } }));
	}

	static int solution(int[][] land) {
		for (int i = land.length - 2; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {// 이번에 선택한 열
				int maxNum = 0;
				for (int t = 0; t < 4; t++) {// 그 아래 열
					if (j != t && maxNum < land[i + 1][t]) {
						maxNum = land[i + 1][t];
					}
				}
				land[i][j] += maxNum;
			}
		}
		Arrays.sort(land[0]);
		return land[0][3];
	}
}
