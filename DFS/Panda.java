package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Panda {

	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int maxCount = 0;
	static int[][] dp;
	static int[][] field;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		field = new int[n][n];
		dp = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = true;
				DFS(visited, i, j);
				visited[i][j] = false;
			}
		}
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(maxCount);
	}

	public static int DFS(boolean[][] visited, int startI, int startJ) {
		int maxNum = 1;
		for (int i = 0; i < 4; i++) {
			int nextI = startI + dI[i];
			int nextJ = startJ + dJ[i];

			// 범위 밖 패스
			if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
				continue;
			}
			
			if (dp[nextI][nextJ] == 0 && field[startI][startJ] < field[nextI][nextJ]
					&& visited[nextI][nextJ] == false) {
				// dp값 계산이 안되어 있고, 본인보다 큰 값이여서 방문이 가능하다면,
				visited[nextI][nextJ] = true;
				maxNum = Math.max(maxNum, 1 + DFS(visited, nextI, nextJ));
				visited[nextI][nextJ] = false;
			} else if (dp[nextI][nextJ] != 0 && field[startI][startJ] < field[nextI][nextJ]
					&& visited[nextI][nextJ] == false) {
				// dp값 계산이 되어있고, 방문이 가능하다면,
				maxNum = Math.max(maxNum, 1 + dp[nextI][nextJ]);
			}
		}
		//dp가 가능한 이유 : 결국 한번 방문한 녀석은 다시 방문할 필요가 없다. 어느 특정 지점에서 최대값을 구하면, 그 값을 이용하면 된다.
		//근거가 되는 조건은 현재 값보다 큰 곳으로만 방문이 가능하니 해당 인덱스에서의 최대값 계산 해놓고 이 인덱스 값보다 작은녀석은 이 녀석과 인접해 있기 때문에
		//방문을 해야하지만 이미 방문이 이루어진 녀석이여서 그대로 값만 이용하면 된다.
		
		//
		//재귀문은 종료시점을 항상 어떻게 끝낼지 생각해라.
		//여기서 재귀문은 상하좌우를 뒤져보고 갈 수 있는 경로 비용이 가장 큰 값을 선택하는 것이다.
		dp[startI][startJ] = maxNum;
		if (maxCount < maxNum) {
			maxCount = maxNum;
		}
		return dp[startI][startJ];
	}
}
