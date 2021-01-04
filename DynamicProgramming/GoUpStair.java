package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoUpStair {
	static int[] dp;
	static int[] scoreArr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairNum = Integer.parseInt(br.readLine());// 계단 300이하
		dp = new int[301];
		scoreArr = new int[stairNum + 1];
		for (int i = 1; i < stairNum + 1; i++) {
			scoreArr[i] = Integer.parseInt(br.readLine());
			// i번째 계단의 점수가 적혀있음.
		}
		// dp[i] : i번째 계단까지 올라왔을 때의 최대값
		dp[0] = 0;
		dp[1] = scoreArr[1];
		if (stairNum > 1) {
			dp[2] = scoreArr[1] + scoreArr[2];
		}
		for (int i = 3; i < scoreArr.length; i++) {
			System.out.println(scoreArr[i]);
			dp[i] = Math.max(dp[i - 3] + scoreArr[i] + scoreArr[i - 1], dp[i - 2] + scoreArr[i]);
		}
		/*
		 * for (int i = 0; i < stairNum + 1; i++) { System.out.print(dp[i] + " "); }
		 */
		System.out.println(dp[stairNum]);
	}
}
