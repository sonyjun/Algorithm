package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public abstract class Resign {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] timeTable = new int[num + 1][2];
		int[] dp = new int[17];
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken());// 걸리는 일수
			timeTable[i][1] = Integer.parseInt(st.nextToken());// 보상
		}
		int maxDp = 0;
		for (int i = num; i >= 1; i--) {
			//System.out.println(i);
			if (i + timeTable[i][0] > num + 1) {// 해당 상담 받아들일 수 없음.
				dp[i] = 0;
			} else {// 해당 상담 받아들일 수 있음.
				int nextDay = i + timeTable[i][0];
				int max = dp[nextDay];
				for (int j = nextDay + 1; j <= num; j++) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
				dp[i] = timeTable[i][1] + max;
			}
			if(maxDp < dp[i]) {
				maxDp = dp[i];
			}
		}
		/*
		 * for (int i = 1; i <= num; i++) { System.out.print(dp[i] + " "); }
		 */
		System.out.println(maxDp);
	}
}
/*
15
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50
1 10
2 20
3 30
4 40
5 50
*/