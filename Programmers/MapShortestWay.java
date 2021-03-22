package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class MapShortestWay {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int[][] staticMap;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));

		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } }));
	}

	public static int solution(int[][] maps) {
		int answer = 0;
		staticMap = maps;
		visited = new boolean[maps.length][maps[0].length];
		BFS(0, 0);
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
		if(maps[maps.length-1][maps[0].length-1] == 1) {
			return -1;
		}else {
			return maps[maps.length-1][maps[0].length-1];
		}
	}

	public static void BFS(int startI, int startJ) {
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(new Pos(startI, startJ, 1));
		visited[startI][startJ] = true;
		while (!que.isEmpty()) {
			Pos pollPos = que.poll();
			if(pollPos.i == staticMap.length-1 && pollPos.j == staticMap[0].length -1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				if (nextI < 0 || nextJ < 0 || nextI >= staticMap.length || nextJ >= staticMap[0].length) {
					continue;
				}
				// 1이 아니면 방문 ㄴㄴ
				if (staticMap[nextI][nextJ] != 1 || visited[nextI][nextJ] == true) {
					continue;
				}
				staticMap[nextI][nextJ] = pollPos.count + 1;
				visited[nextI][nextJ] = true;
				que.add(new Pos(nextI, nextJ, pollPos.count + 1));
			}
		}
	}
}

class Pos {
	int i;
	int j;
	int count;

	public Pos(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}
}