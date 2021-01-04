package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {
	static int[] dp;
	static int callOne = 0;
	static int callZero = 0;
	static int[][] count;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		count = new int[41][2];
		dp = new int[41];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 0; i <= 40; i++) {
			makeDP(i);
			count[i][0] = callZero;
			count[i][1] = callOne;
			callZero = 0;
			callOne = 0;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < testCaseNum; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(count[x][0]+" "+count[x][1]+"\n");
		}
		System.out.println(sb);
	}

	public static int makeDP(int x) {
		if (x == 0) {
			callZero++;
			return 0;
		} else if (x == 1) {
			callOne++;
			return 1;
		}
		if (dp[x] != 0) {
			callZero += count[x][0];
			callOne += count[x][1];
			return dp[x];
		}
		return dp[x] = makeDP(x - 2) + makeDP(x - 1);
	}
}
