package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static Queue<PositionE> que = new LinkedList<PositionE>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];

		// . -> 0
		// S -> 1
		// D -> 2
		// * -> 3
		// X -> 4
		int startI = 0;
		int startJ = 0;
		int endI = 0;
		int endJ = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'S') {
					field[i][j] = 1;
					startI = i;
					startJ = j;
				} else if (str.charAt(j) == 'D') {
					field[i][j] = 2;
					endI = i;
					endJ = j;
				} else if (str.charAt(j) == '*') {
					que.add(new PositionE(i, j, 0, 3));// 물 먼저 넣어주고
					field[i][j] = 3;
				} else if (str.charAt(j) == 'X') {
					field[i][j] = 4;
				}
			}
		}
		BFS(field, startI, startJ, endI, endJ);
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}*/
	}

	public static void BFS(int[][] field, int startI, int startJ, int endI, int endJ) {

		// . -> 0
		// S -> 1
		// D -> 2
		// * -> 3
		// X -> 4
		que.add(new PositionE(startI, startJ, 0, 1));// 고슴도치 위치 넣어줌
		while (!que.isEmpty()) {
			PositionE pollPos = que.poll();
			if (pollPos.i == endI && pollPos.j == endJ && pollPos.who == 1) {
				System.out.println(pollPos.distance);
				return;
			}
			int who = pollPos.who;
			int distance = pollPos.distance;
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 0이면 방문하자
				if (who == 1) {
					if (field[nextI][nextJ] == 0 || field[nextI][nextJ] == 2) {
						field[nextI][nextJ] = 1;
						que.add(new PositionE(nextI, nextJ, distance + 1, who));
					}
				}
				if (who == 3) {
					if (field[nextI][nextJ] == 0 || field[nextI][nextJ] == 1) {
						field[nextI][nextJ] = 3;
						que.add(new PositionE(nextI, nextJ, 0, who));
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}

class PositionE {
	int i;
	int j;
	int distance;
	int who;

	public PositionE(int i, int j, int distance, int who) {
		this.i = i;
		this.j = j;
		this.distance = distance;
		this.who = who;
	}
}