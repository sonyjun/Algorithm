package Programmers;

public class 등굣길 {
	public static void main(String[] args) {
		Solution등굣길 s = new Solution등굣길();
		s.solution(4, 3, new int[][] { { 2, 2 } });
		s.solution(7, 4,
				new int[][] { { 2, 1 }, { 2, 2 }, { 2, 3 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 6, 2 }, { 6, 3 } });
		s.solution(4, 4, new int[][] { { 3, 2 }, { 2, 4 } });
		s.solution(3, 3, new int[][] { { 1, 3 }, { 3, 1 } });
		s.solution(3, 3, new int[][] { { 1, 3 }, { 3, 1 }, { 2, 3 } });
		s.solution(3, 3, new int[][] { { 1, 3 }, { 3, 1 }, { 2, 3 }, { 2, 1 } });
		s.solution(100, 100, new int[][] {});
	}
}

class Solution등굣길 {
	int[][] field;
	int[][] dp;
	int M;
	int N;
	int[] dI = { 0, 1 };
	int[] dJ = { 1, 0 };

	public int solution(int m, int n, int[][] puddles) {
		field = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		for (int i = 0; i < puddles.length; i++) {
			field[puddles[i][1]][puddles[i][0]] = 1;
		}
		M = m;
		N = n;
		DFS(1, 1);
		return dp[1][1];
	}

	public int DFS(int i, int j) {
		if (i == N && j == M) {
			return 1;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		for (int t = 0; t < 2; t++) {
			int nextI = i + dI[t];
			int nextJ = j + dJ[t];
			if (nextI <= 0 || nextJ <= 0 || nextI >= field.length || nextJ >= field[0].length) {
				continue;
			}
			if (field[nextI][nextJ] != 1) {
				dp[i][j] += DFS(nextI, nextJ) % 1000000007;
			}
		}
		dp[i][j] %= 1000000007;
		return dp[i][j];
	}
}