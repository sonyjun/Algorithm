package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NormalBackPack {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] objectArr = new int[n+1][2];
		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			objectArr[i][0] = Integer.parseInt(st.nextToken());
			objectArr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if(objectArr[i][0] <= j) {// i번째 물건이 받아 들여 질 수 있다면, 받아들여졌을 때의 값과 안받아들여 졌을 때의 값을 비교.
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-objectArr[i][0]] + objectArr[i][1]);
				}else {// 없다면,
					dp[i][j] = dp[i-1][j];// 결국 내가 들어갈 공간이 없는거니까, j-1을 갖고오면 다 0을 갖고올 것임. 이제껏 누적값 안보고 본인만 루프만 고려하겠다는 얘기임.
										  // 본인이 받아들여지기 이전에 있던 그 무게에서의 최대가치를 갖고오는 게 맞지.
				}
			}
		}
		System.out.println(dp[n][w]);
	}
}
