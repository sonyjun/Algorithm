package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int floorNum = Integer.parseInt(br.readLine());//삼각형 크기는 500이하
		int[][] triangleField = new int[floorNum + 1][floorNum + 1];
		int index = 1;
		int[][] dp = new int[floorNum + 1][floorNum + 1];
		for (int i = 1; i < floorNum + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				triangleField[i][index++] = Integer.parseInt(st.nextToken());
			}
			index = 1;
		}
		dp[1][1] = triangleField[1][1];
		for (int i = 2; i < triangleField.length; i++) {// dp[2][x] 부터 보면 됨
			for (int j = 1; j < triangleField.length; j++) {// dp[2][1] ~ 시작
				if (j == 0) {// 제일 왼쪽 놈
					dp[i][j] = triangleField[i][j] + dp[i - 1][j];
				} else if (j == i) {// 제일 오른쪽 놈
					dp[i][j] = triangleField[i][j] + dp[i - 1][j - 1];
				} else {// 중간에 낀놈.
					dp[i][j] = Math.max(dp[i - 1][j - 1] + triangleField[i][j], dp[i - 1][j] + triangleField[i][j]);
				}
			}
		}
		int maxNum = 0;
		for (int i = 1; i < dp.length; i++) {
			maxNum = Math.max(maxNum, dp[dp.length - 1][i]);
		}
/*
		for (int i = 1; i < floorNum + 1; i++) {
			for (int j = 1; j < floorNum + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(maxNum);
	}
}
