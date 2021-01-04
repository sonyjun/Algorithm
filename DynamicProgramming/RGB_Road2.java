package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_Road2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] dp = new int[num][3];
		int[][] houseCostArr = new int[num][3];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			houseCostArr[i][0] = Integer.parseInt(st.nextToken());
			houseCostArr[i][1] = Integer.parseInt(st.nextToken());
			houseCostArr[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = houseCostArr[0][0];
		dp[0][1] = houseCostArr[0][1];
		dp[0][2] = houseCostArr[0][2];
		for (int i = 1; i < num; i++) {
			dp[i][0] = houseCostArr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = houseCostArr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = houseCostArr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		int min = 1000 * num + 1;
		for (int i = 0; i < 3; i++) {
			if (min > dp[num - 1][i]) {
				min = dp[num - 1][i];
			}
		}
		System.out.println(min);
	}
}
