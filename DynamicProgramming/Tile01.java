package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tile01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		long[] dpT = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dpT[1]=1;
		dpT[2]=2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
			dpT[i] = dpT[i - 2] + dpT[i - 1];
		}
		System.out.println(dp[n]);
		System.out.println(dpT[n]);
		System.out.println(dpT[n] % 15746);
	}
}