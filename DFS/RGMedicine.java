package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
5
RRBRR
GGGGG
BBBRR
BBRRR
RRRRR
 */
public class RGMedicine {

	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int normalCount = 0;
	static int abNormalCount = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][n];
		// 0 : Blue
		// 1 : Green
		// 2 : Red
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == 'G') {
					field[i][j] = 1;
				} else if (str.charAt(j) == 'R')
					field[i][j] = 2;
			}
		}
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[i][j] == 0 || field[i][j] == 1 || field[i][j] == 2) {
					System.out.println(i+","+j);
					searchFieldNormal(field, i, j);
					normalCount++;
				}
			}
		}
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 3 || field[i][j] == 4 || field[i][j] == 5) {
					searchFieldAbNormal(field, i, j);
					abNormalCount++;
				}
			}
		}
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println(normalCount+" "+abNormalCount);

	}

	public static void searchFieldNormal(int[][] field, int startI, int startJ) {

		// 0 : Blue
		// 1 : Green
		// 2 : Red
		Queue<PositionO> que = new LinkedList<PositionO>();
		que.add(new PositionO(startI, startJ));
		int visitNum = field[startI][startJ];
		field[startI][startJ]+=3;
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
				if (field[nextI][nextJ] != visitNum) {
					continue;
				}
				// 위에껄 다 지나면 방문해야되는 친구임.
				// 최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
				field[nextI][nextJ] = visitNum + 3;
				que.add(new PositionO(nextI, nextJ));
			}
		}
	}

	public static void searchFieldAbNormal(int[][] field, int startI, int startJ) {

		// 3 : Blue
		// 4 : Green
		// 5 : Red
		Queue<PositionO> que = new LinkedList<PositionO>();
		que.add(new PositionO(startI, startJ));
		int visitNum = field[startI][startJ];
		field[startI][startJ]+=3;
		while (!que.isEmpty()) {
			PositionO pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				
				if (visitNum == 4 || visitNum == 5) {
					if (field[nextI][nextJ] != 4 && field[nextI][nextJ] != 5) {
						continue;
					}
				} else {
					if (field[nextI][nextJ] != visitNum) {
						continue;
					}
				}

				// 위에껄 다 지나면 방문해야되는 친구임.
				// 최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
				field[nextI][nextJ] = visitNum + 3;
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
