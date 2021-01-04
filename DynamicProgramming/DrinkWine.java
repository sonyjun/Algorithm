package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrinkWine {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int wineNum = Integer.parseInt(br.readLine());
		int[] wineCost = new int[wineNum + 1];
		int[] dp = new int[10001];
		for (int i = 1; i <= wineNum; i++) {
			wineCost[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = wineCost[1];
		if (wineNum > 1) {
			dp[2] = wineCost[1] + wineCost[2];
		}
		int maxNum = 0;
		for (int i = 3; i <= wineNum; i++) {
			maxNum = 0;
			maxNum = Math.max(dp[i - 3] + wineCost[i - 1] + wineCost[i], dp[i - 1]);
			maxNum = Math.max(maxNum, dp[i - 2] + wineCost[i]);
			dp[i] = maxNum;
		}
		System.out.println(dp[wineNum]);
	}
}
