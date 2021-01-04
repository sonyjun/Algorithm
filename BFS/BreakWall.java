package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//어떤 길을 개척하는데 벽을 허물 수 있다는 찬스? 최단경로 + 부가적인 조건.

public class BreakWall {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static Queue<PositionB> que = new LinkedList<PositionB>();
	static int minimum = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '1') {
					field[i][j] = 1;
				}
			}
		}

		BFS(field);
		if (minimum == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minimum);
		}
	}

	public static void BFS(int[][] field) {
		que.add(new PositionB(0, 0, 1, false));// i,j좌표,count,벽 부순 여부(0안부슴)
		boolean[][][] visited = new boolean[field.length][field[0].length][2];
		visited[0][0][0] = true;// 0,0좌표는 이제 더이상 방문 못하게.
		visited[0][0][1] = true;// 0,0좌표는 이제 더이상 방문 못하게.
		// 원래 0은 벽을 안 부수고 온 녀석이 지나갔는지 여부.
		// 1은 벽을 부수고 온 녀석이 지나갔는지 여부.
		while (!que.isEmpty()) {
			PositionB pollPos = que.poll();
			if (pollPos.i == field.length - 1 && pollPos.j == field[0].length - 1) {
				minimum = Math.min(minimum, pollPos.distance);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				int distance = pollPos.distance;
				boolean isBrokeWall = pollPos.breakWall;
				// 0은 안뿌심. 1은 뿌심

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}

				if (isBrokeWall == true) {// 벽을 부순 녀석이 주변을 탐색.
					if (field[nextI][nextJ] == 1) {// 벽을 부수고 왔기 때문에, 더 이상 부술 수 없다.
						continue; // 너는 이 방향으로 못간다.(상하좌우 중 한 군데가 여길 도는 거니까)
									// 예를 들어 아래로는 갈 수 있는 경우, 아래에서는 조건문 0에 걸리겠지.
									// 하지만 오른쪽이 1이여서 못가는 경우, 해당 루프는 종료 시켜야지

					} else if (field[nextI][nextJ] == 0 && visited[nextI][nextJ][1] == false) {
						// 벽을 부수고 왔지만 0을 만났다면, 또 그 정점이 방문되지 않았다면, BFS는 진행된다.
						// 방문이 되었다면, 누군가 나보다 최단거리로 하여금 그 곳을 지나갔다는 얘기다.

						visited[nextI][nextJ][1] = true;
						que.add(new PositionB(nextI, nextJ, distance + 1, true));
					}
				} else {// 벽을 부수지 않은 녀석이 주변을 탐색.
					if (field[nextI][nextJ] == 1 && visited[nextI][nextJ][1] == false) {
						// 벽을 허물어야 될 시점이 왔다면,, 벽을 허물거다. 누군가 그 벽을 허물지 않았다면.
						// 벽이 허물어져 있다면 나보다 빠른 놈이 그 벽을 허물고 지나간 것이다.

						visited[nextI][nextJ][1] = true;
						que.add(new PositionB(nextI, nextJ, distance + 1, true));

					} else if (field[nextI][nextJ] == 0 && visited[nextI][nextJ][0] == false) {
						// 벽이 없다면 누가 방문했는지 확인한 후에 지나간다.
						// 과거에 벽을 허물지 않았던 친구 중에 나보다 빠른 놈이 그 벽을 허물고 지나간 것이다.
						visited[nextI][nextJ][0] = true;
						que.add(new PositionB(nextI, nextJ, distance + 1, false));
					}
				}
			}
		}

	}
}

class PositionB {
	int i;
	int j;
	int distance;
	boolean breakWall;

	public PositionB(int i, int j, int distance, boolean breakWall) {
		this.i = i;
		this.j = j;
		this.distance = distance;
		this.breakWall = breakWall;
	}
}