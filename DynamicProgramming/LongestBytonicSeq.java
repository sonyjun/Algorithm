package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestBytonicSeq {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dp = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < dp.length; i++) {// dp[i][0] => i번째 숫자가 증가로 포함될 때 최대길이, dp[i][1] => i번째 숫자가 감소로 포함될 때 최대길이
			for (int j = i - 1; j >= 1; j--) {
				if (numArr[j] < numArr[i]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]);
				} else if (numArr[j] > numArr[i]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][0]);
					dp[i][1] = Math.max(dp[i][1], dp[j][1]);
				}
			}
			dp[i][0] += 1;
			dp[i][1] += 1;
		}
		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i][0]);
			max = Math.max(max, dp[i][1]);
			//System.out.println("i :" + i + "    " + dp[i][0] + "," + dp[i][1]);
		}
		System.out.println(max);
	}
}
