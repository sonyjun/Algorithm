package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WannaPresident {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];// i는 0부터 다룬다. j는 1부터 다룬다.
		for(int i = 1; i < dp[0].length ; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		for (int i = 0; i < testCaseNum; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[k][n]);
		}
	}
}
