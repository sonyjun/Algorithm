package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixMulOrder {// 백준 행렬 곱셈 순서. 11049번
	//유형 : 순서를 지켜야한다. 왼쪽이랑 합칠지 오른쪽이랑 합칠지 모른다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] NMarr = new int[501][2];
		int[][] dp = new int[501][501];
		for (int j = 1; j <= N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			NMarr[j][0] = Integer.parseInt(st.nextToken());
			NMarr[j][1] = Integer.parseInt(st.nextToken());
		}
		for (int d = 1; d < N; ++d) {
			for (int tx = 1; tx + d <= N; ++tx) {
				int ty = tx + d;
				dp[tx][ty] = Integer.MAX_VALUE;

				for (int mid = tx; mid < ty; ++mid)
					dp[tx][ty] = Math.min(dp[tx][ty],
							dp[tx][mid] + dp[mid + 1][ty] + (NMarr[tx][0] * NMarr[mid][1] * NMarr[ty][1]));
			}
		}
		bw.write(dp[1][N] + "\n");
		bw.close();
	}
}
