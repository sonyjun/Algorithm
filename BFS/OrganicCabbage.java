package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());// 테스트케이스 수

		for (int i = 0; i < caseNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());// 가로 크기
			int n = Integer.parseInt(st.nextToken());// 세로 크기
			int cabbageNum = Integer.parseInt(st.nextToken());
			int[][] field = new int[n][m];
			for (int j = 0; j < cabbageNum; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}
			int symbol = 1;
			for (int t = 0; t < n; t++) {
				for (int j = 0; j < m; j++) {
					if (field[t][j] == 1) {
						BFS(field, t, j, ++symbol);
					}
					// System.out.print(field[t][j]);
				}
				// System.out.println();
			}
			/*System.out.println();
			System.out.println();
			for (int t = 0; t < n; t++) {
				for (int j = 0; j < m; j++) {
					System.out.print(field[t][j]);
				}
				System.out.println();
			}*/
			System.out.println(symbol - 1);
		}
	}

	public static void BFS(int[][] field, int startI, int startJ, int symbol) {
		Queue<PositionO> que = new LinkedList<PositionO>();
		que.add(new PositionO(startI, startJ));
		while (!que.isEmpty()) {
			PositionO pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 1이 아니면 방문 ㄴㄴ
				if (field[nextI][nextJ] != 1) {
					continue;
				}
				// 위에껄 다 지나면 방문해야되는 친구임.
				// 최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
				field[nextI][nextJ] = symbol;
				que.add(new PositionO(nextI, nextJ));
			}
		}
	}
}

class PositionO {
	int i;
	int j;

	public PositionO(int i, int j) {
		this.i = i;
		this.j = j;
	}
}