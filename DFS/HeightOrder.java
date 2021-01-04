package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeightOrder {
	static int INF = 10000000;
	// static int[][] arr = new int[][] { { 0, 5, INF, 8 }, { 7, 0, 9, INF }, { 2,
	// INF, 0, 4 }, { INF, INF, 3, 0 } };
	// static int[][] arr = new int[][] { { 0, 1, INF, INF }, { INF, 0, 1, INF }, {
	// INF, INF, 0, 1 },{ INF, INF, INF, INF } };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		int m = Integer.parseInt(st.nextToken());
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (i == j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = INF;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		/*
		 * 시나리오를 얘기하면, i는 이번에 방문하는 정점에 해당된다. 이 정점과 연관있는 인덱스를 제외한 나머지 인덱스들을 인접행렬을 통해
		 * 방문하면서 갱신이 필요하다면 갱신하는 구조이다. i는 방문하는 정점. j,t는 인접행렬을 방문하는 지표.
		 * 
		 */
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				for (int t = 1; t < arr[0].length; t++) {
					if (j != i && t != i && j != t) {
						// System.out.println("i: " + i + ", j : " + j + ", t :" + t);
						if (arr[j][i] + arr[i][t] < arr[j][t]) {
							arr[j][t] = arr[j][i] + arr[i][t];
						}
					}
				}

			}
		}

		int count = 0;

		for (int i = 1; i < arr.length; i++) {
			boolean isPass = true;
			for (int j = 1; j < arr[0].length; j++) {

				//System.out.print(arr[i][j] + " ");
				if (arr[i][j] == INF && arr[j][i] == INF) {
					isPass = false;
					break;
				}
			}
			//System.out.println();
			if (isPass) {
				count++;
			}
		}
		System.out.println(count);
	}
}
