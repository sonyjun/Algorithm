package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IceMountain {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		checkSet(field);

	}

	public static void checkSet(int[][] field) {
		boolean[][] visited;
		int year = 0;
		int count = 0;
		while (count < 2) {
			count = 0;
			visited = new boolean[field.length][field[0].length];
			//배열을 탐색하면서 0이 아닌 녀석이 있으면 BFS를 돌림.
			//count는 집합의 갯수를 의미, BFS가 호출된 수 만큼의 그룹이 있다는 뜻임.
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					//배열의 값(방문표시 용도 등으로 쓸 수 있지만) 따로 건들 수 없었기 때문에 방문배열이 필요했음.
					if (field[i][j] != 0 && visited[i][j] == false) {
						count++;
						BFS(field, i, j, visited);
					}
				}
			}
			//BFS가 한번도 호출되지 않았다 = 0이 아닌 인덱스가 하나도 없다 = 빙하가 다 녹았다.
			if (count == 0) {// 다 녹아버린것....
				System.out.println(0);
				return;
			}
			//count == 0을 걸러서 왔기 때문에 무조건 1개 이상의 무리가 있다는 뜻임. 
			//그게 2이상이라면 결과값을 출력할 것이고, 1이라면 1년을 지나게 한 뒤 다시 BFS탐색을 시도할 것임.
			if (count < 2) {// 두개로 분리되지 않으면 1년 지나게 하고 다시 BFS
				field = afterYear(field);
				year++;
			}
			
		}
		System.out.println(year);
	}

	public static void BFS(int[][] field, int startI, int startJ, boolean[][] visited) {
		Queue<PositionI> que = new LinkedList<PositionI>();
		visited[startI][startJ] = true;
		que.add(new PositionI(startI, startJ));
		while (!que.isEmpty()) {
			PositionI pollPos = que.poll();
			int i = pollPos.i;
			int j = pollPos.j;
			for (int t = 0; t < 4; t++) {
				int nextI = i + dI[t];
				int nextJ = j + dJ[t];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 0이면 방문하자
				if (field[nextI][nextJ] != 0 && visited[nextI][nextJ] == false) {
					visited[nextI][nextJ] = true;
					que.add(new PositionI(nextI, nextJ));
				}
			}
		}

	}

	public static int[][] afterYear(int[][] field) {//빙산이 1년이 지났을 때를 반환해줌.
		int[][] afterField = new int[field.length][field[0].length];
		//afterField가 필요한 이유는 모두 동시에 빙산이 녹아야 하는데, 작은 인덱스부터 차례대로 할 경우
		//녹아버려서 0이 된 녀석이 다른녀석에게 영향을 줄 수도 있음. 따라서 별도의 결과를 저장할 수 있는 배열이 필요해서 선언.
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] != 0) {// 0이 아닌 곳은 상하좌우의 0의 갯수를 구하고 삭감해줌
					int count = 0;
					for (int t = 0; t < 4; t++) {
						int nextI = i + dI[t];
						int nextJ = j + dJ[t];

						// 범위 밖 패스
						if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
							continue;
						}
						// 0이면 방문하자
						if (field[nextI][nextJ] == 0) {
							count++;
						}
					}
					int result = field[i][j] - count;
					if (result >= 0) {
						afterField[i][j] = result;
					} else {
						afterField[i][j] = 0;
					}
				}
			}
		}
		return afterField;
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
