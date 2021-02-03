package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DownHillRoad {// 백준 내리막길. 1520번
	static int[][] field;
	static int[][] dp;
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int M;
	static int N;
	static int count = 0;
	static int callCount = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		field = new int[501][501];
		dp = new int[501][501];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		DFS(1, 1);
		System.out.println(dp[1][1]);
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int DFS(int startI, int startJ) {
		if (startI == M && startJ == N) {
			count++;
			return 1;
		}

		if (dp[startI][startJ] == -1) {
			// -1은 아예 방문을 안한 것. 방문을 해줄 필요가 있음 .
			dp[startI][startJ] = 0;// 방문했으면 0으로 표시함.
			int currentValue = field[startI][startJ];
			for (int i = 0; i < 4; i++) {
				int nextI = startI + dI[i];
				int nextJ = startJ + dJ[i];
				// 범위 밖 패스
				if (nextI <= 0 || nextJ <= 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 현재 층보다 작다면 넘어갈 수 있음.
				if (currentValue > field[nextI][nextJ]) {
					dp[startI][startJ] += DFS(nextI, nextJ);
				}
			}
		}
		// 이 구문을 도는 지점은 방문을 했던 지점임.
		// 1. 만약 아무곳도 방문할 수 있는 곳이 없을 때 0을 반환하겠지.
		// 2. 방문을 했던 곳이라면 해당 지점에서 도착지점까지 갈 수 있는 길의 갯수를 반환.
		// 최종적으로 dp[1][1]은 출발지점이니, 갈래길이 총 몇개 있는지 기록되게 됨.
		// dp[i][j]는 해당 지점에서 도착지점까지 갈 수 있는 갈래길을 뜻함.
		return dp[startI][startJ];
	}
}
/*
 5 5
 50 45 37 32 30
 35 50 40 20 25
 30 25 25 17 28
 25 30 25 16 28
 24 23 22 15 10
 */
