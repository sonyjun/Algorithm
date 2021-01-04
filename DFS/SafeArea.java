package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafeArea {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int maxNum = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][n];
		boolean[][] visited;
		int statNum = 101;
		int endNum = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				field[i][j] = temp;
				if (temp < statNum) {
					statNum = temp;
				}
				if (temp > endNum) {
					endNum = temp;
				}
			}
		}
		
		int maxArea = 0;
		int count = 0;
		for (int t = statNum - 1; t < endNum; t++) {
			visited = new boolean[n][n];
			count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == false && field[i][j] > t) {
						count++;
						BFS(field, i, j, visited, t);
					}
				}
			}
			/*for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == true) {
						System.out.print(1+" ");
					}else {
						System.out.print(0+" ");
					}
				}
				System.out.println();
			}
			System.out.println("height : "+t+", count: "+count);
			System.out.println();*/
			if(maxArea < count) {
				maxArea = count;
			}
		}
		System.out.println(maxArea);
	}

	public static void BFS(int[][] field, int startI, int startJ, boolean[][] visited, int height) {
		Queue<PositionS> que = new LinkedList<PositionS>();
		visited[startI][startJ] = true;
		que.add(new PositionS(startI, startJ));
		while (!que.isEmpty()) {
			PositionS pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 1이 아니면 방문 ㄴㄴ
				if (visited[nextI][nextJ] == false && field[nextI][nextJ] > height) {
					visited[nextI][nextJ] = true;
					que.add(new PositionS(nextI, nextJ));
				}
			}
		}
	}
}

class PositionS {
	int i;
	int j;

	public PositionS(int i, int j) {
		this.i = i;
		this.j = j;
	}
}