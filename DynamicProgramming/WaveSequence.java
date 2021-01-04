package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WaveSequence {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		int[] inputNum = new int[testCaseNum];
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 0; i < testCaseNum; i++) {
			inputNum[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < inputNum.length; i++) {
			for (int j = 4; j <= inputNum[i]; j++) {
				if (dp[j] == 0) {
					dp[j] = dp[j - 3] + dp[j - 2];
				} else {
					continue;
				}
			}
			System.out.println(dp[inputNum[i]]);
		}
	}
}
