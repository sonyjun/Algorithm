package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindBead {
	static int INF = 10000000;
	static int[][] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int beadNum = Integer.parseInt(st.nextToken());
		int compareNum = Integer.parseInt(st.nextToken());
		arr = new int[beadNum + 1][beadNum + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (i != j) {
					arr[i][j] = INF;
				}
			}
		}
		for (int i = 0; i < compareNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;// x가 y를 이긴다.
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
		
		int answer = 0;
		int cutLine = (beadNum + 1) / 2;
		int loseCount = 0;
		int winCount = 0;
		for (int i = 1; i < arr.length; i++) {
			loseCount = 0;
			winCount = 0;
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] == INF && arr[j][i] != INF) {
					loseCount++;
				}
				if (arr[i][j] > 0 && arr[i][j] < INF) {
					winCount++;
				}
			}
			if (loseCount >= cutLine || winCount >= cutLine) {
				answer++;
			}
		}
		System.out.println(answer);
		/*
		 * for (int i = 1; i < arr.length; i++) { for (int j = 1; j < arr[0].length;
		 * j++) { System.out.print(arr[i][j] + " "); } System.out.println(); }
		 */
	}
}
