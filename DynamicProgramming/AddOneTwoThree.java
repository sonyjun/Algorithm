package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddOneTwoThree {
	static int[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		dp = new int[20];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			makeDP(i);
		}
		for (int i = 0; i < testCaseNum; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}

	public static int makeDP(int x) {
		if (dp[x] != 0)
			return dp[x];
		return dp[x] = dp[x - 3] + dp[x - 2] + dp[x - 1];
	}
}
