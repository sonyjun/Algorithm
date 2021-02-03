package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1 {// 백준 동전1. 2293번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coinWorthArr = new int[n + 1];
		int[][] dp = new int[101][10001];
		for (int i = 1; i <= n; i++) {
			coinWorthArr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= n; i++) {
			int worth = coinWorthArr[i];
			for (int j = 1; j <= k; j++) {
				for (int t = 0; t * worth <= j; t++) {
					dp[i][j] += dp[i - 1][j - t * worth];
					if (j == t * worth) {
						dp[i][j] += 1;
					}
				}
			}
		}
		System.out.println(dp[n][k]);
		/*
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}
}
