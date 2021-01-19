package DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuardTree { // 백준 쿼드트리. 1992번
	static int[][] videoArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		videoArr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				videoArr[i][j] = Integer.parseInt(str.charAt(j - 1) + "");
			}
		}
/*
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(videoArr[i][j]);
			}
			System.out.println();
		}*/
		System.out.println(divideConquer(1, 1, n));
	}

	public static String divideConquer(int startI, int startJ, int size) {
		int zeroCount = 0;
		int oneCount = 0;
		for (int i = startI; i < startI + size; i++) {
			for (int j = startJ; j < startJ + size; j++) {
				if (videoArr[i][j] == 0) {
					zeroCount++;
				} else {
					oneCount++;
				}
			}
		}

		if (zeroCount == 0 && oneCount > 0) {
			return 1 + "";
		} else if (zeroCount > 0 && oneCount == 0) {
			return 0 + "";
		} else {
			return "(" + divideConquer(startI, startJ, size / 2) + divideConquer(startI, startJ + size / 2, size / 2)
					+ divideConquer(startI + size / 2, startJ, size / 2)
					+ divideConquer(startI + size / 2, startJ + size / 2, size / 2) + ")";
		}
	}
}
