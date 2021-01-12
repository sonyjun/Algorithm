package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MethodExecute {
	static int[][][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		dp = new int[21][21][21];
		for (int a = 0; a <= 20; a++) {
			for (int b = 0; b <= 20; b++) {
				for (int c = 0; c <= 20; c++) {
					if (a <= 0 || b <= 0 || c <= 0) {
						dp[a][b][c] = 1;
						continue;
					}
					if (a < b && b < c) {
						dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
						continue;
					} else {
						dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1]
								- dp[a - 1][b - 1][c - 1];
						continue;
					}

				}
			}
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			sb.append(W(a, b, c));
		}
		System.out.println(sb);
	}

	public static String W(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return "w("+a+", "+b+", "+c+") = "+1+"\n";
		}
		if (a > 20 || b > 20 || c > 20) {
			return "w("+a+", "+b+", "+c+") = "+dp[20][20][20]+"\n";
		}
		return "w("+a+", "+b+", "+c+") = "+dp[a][b][c]+"\n";
	}
}
