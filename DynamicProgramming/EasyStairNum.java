package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EasyStairNum {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairNum = Integer.parseInt(br.readLine());
		long[][] dp = new long[101][11];
		long a = 1000000000;
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= stairNum; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1] % a);
			}
		}
		long sum = 0;
		for (int i = 0; i < dp[0].length; i++) {
			sum += dp[stairNum][i];
		}
		System.out.println(sum % a);
	}
}
