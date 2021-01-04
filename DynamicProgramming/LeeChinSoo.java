package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeeChinSoo {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numSize = Integer.parseInt(br.readLine());
		long[] dp = new long[91];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= numSize; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[numSize]);
	}
}
