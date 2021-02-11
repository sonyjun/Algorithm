package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze2 {
	static int[] dI = { 0, 0, 1, -1 };
	static int[] dJ = { -1, 1, 0, 0 };
	static int[][] adjArr;
	static int n;
	static int m;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		adjArr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < inputStr.length(); j++) {
				adjArr[i][j + 1] = Integer.parseInt(inputStr.charAt(j) + "");
			}
		}
		BFS();
		int answer = adjArr[n][m];
		if(answer == -1) {
			bw.write("0");
		}else {
			bw.write(answer+"");
		}
		bw.close();
		/*for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	// BFS는 que를 이용한 너비우선탐색.
	// DFS는 재귀를 이용한 깊이우선탐색.
	// 둘다 결국 최종 목적지 까진 가능한 모든 경우를 탐색함.

	// BFS는 동시에 넓게 살펴보는 것.
	// Class를 통해 count값을 기억하는 방식이든 뭐든,, 먼저 도착하는 애가 빠른거임. que에서 뒤에 오는 애들은 나보다 같거나
	// 느린애들.

	// DFS는 하나만 깊게 파고, 나머지도 깊게 파고 이런식으로 진행. 먼저 도착하는 애가 빠르지 않음. 가중치나 이런 기억해둘 필요가 있는
	// 시스템에 이용

	public static void BFS() {
		Queue<PositionM> que = new LinkedList<PositionM>();
		que.add(new PositionM(1, 1, 1));
		adjArr[1][1] = -1;
		while (!que.isEmpty()) {
			PositionM pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				if (nextI < 1 || nextJ < 1 || nextI >= adjArr.length || nextJ >= adjArr[0].length) {
					continue;
				}

				if (adjArr[nextI][nextJ] != 0 && adjArr[nextI][nextJ] == 1) {
					adjArr[nextI][nextJ] = pollPos.count + 1;
					que.add(new PositionM(nextI,nextJ,pollPos.count + 1));
				}
			}
		}

		/*for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}*/
	}
}

class PositionM {
	int i = 0;
	int j = 0;
	int count = 0;

	public PositionM(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}
}
