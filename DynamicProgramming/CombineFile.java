package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CombineFile {// 백준 파일 합치기. 11066번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {
			int K = Integer.parseInt(br.readLine());
			int[] sum = new int[501];
			int[][] dp = new int[501][501];
			//int[] numArr = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= K; j++) {
				sum[j] = sum[j-1]+ Integer.parseInt(st.nextToken());
			}
			for (int d = 1; d < K; ++d) {
	            for (int tx = 1; tx + d <= K; ++tx) {
	                int ty = tx + d;
	                dp[tx][ty] = Integer.MAX_VALUE;
	 
	                for (int mid = tx; mid < ty; ++mid)
	                    dp[tx][ty] =
	                    Math.min(dp[tx][ty], dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
	            }
	        }
			bw.write(dp[1][K]+"\n");
		}
		bw.close();
	}
}
