package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IslandNum { // 섬의 개수. 백준 : 4963번
	static int[][] island;
	static int[] dI = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dJ = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int islandNum = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}

			island = new int[H + 1][W + 1];
			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= W; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			islandNum = 1;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					if(island[i][j] == 1) {
						islandNum++;
						BFS(i,j);
					}
				}
			}
			sb.append(islandNum-1+"\n");
			/*
			 * for (int i = 1; i <= H; i++) { for (int j = 1; j <= W; j++) {
			 * System.out.print(island[i][j]+" "); } System.out.println(); }
			 */
		}
		System.out.println(sb);
	}

	public static void BFS(int startI, int startJ) {
		Queue<PositionI> que = new LinkedList<PositionI>();
		que.add(new PositionI(startI, startJ));
		island[startI][startJ] = islandNum;
		while (!que.isEmpty()) {
			PositionI pollPos = que.poll();
			for (int i = 0; i < 8; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= island.length || nextJ >= island[0].length) {
					continue;
				}
				// 1이 아니면 방문 ㄴㄴ
				if (island[nextI][nextJ] != 1) {
					continue;
				}
				island[nextI][nextJ] = islandNum;
				que.add(new PositionI(nextI, nextJ));
			}
		}
	}
}

class PositionI {
	int i;
	int j;

	public PositionI(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
