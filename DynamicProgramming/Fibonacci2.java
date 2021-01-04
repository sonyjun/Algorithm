package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci2 {
	static long[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		dp = new long[91];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < inputNum; i++) {
			makeDP(i);
		}
		System.out.println(makeDP(inputNum));
	}

	public static long makeDP(int x) {
		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		}
		if (dp[x] != 0) {
			return dp[x];
		}
		return dp[x] = dp[x - 2] + dp[x - 1];
	}
}
