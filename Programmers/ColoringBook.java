package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };

	static int areaNum = 0;
	static int maxArea = Integer.MIN_VALUE;
	static int[][] field;

	public static void main(String[] args) {
		int[] answer1 = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		System.out.println(answer1[0]);
		System.out.println(answer1[1]);
		/*
		 * int[] answer2 = solution(1, 1, new int[][] { { 0 } });
		 * System.out.println(answer2[0]); System.out.println(answer2[1]);
		 */

	}

	public static int[] solution(int m, int n, int[][] picture) {
		areaNum = 0;
		maxArea = Integer.MIN_VALUE;
		field = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				field[i][j] = picture[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j] > 0) {
					int searchNum = field[i][j];
					BFS(i, j, searchNum);
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = Math.abs(areaNum);
		answer[1] = maxArea == Integer.MIN_VALUE ? 0 : maxArea;
		return answer;
	}

	public static void BFS(int startI, int startJ, int searchNum) {
		areaNum++;
		int count = 0;
		Queue<Position> que = new LinkedList<Position>();
		que.add(new Position(startI, startJ));
		field[startI][startJ] = -Math.abs(areaNum);
		while (!que.isEmpty()) {
			count++;
			Position pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				// 1이 아니면 방문 ㄴㄴ
				if (field[nextI][nextJ] != searchNum) {
					continue;
				}
				// 위에껄 다 지나면 방문해야되는 친구임.
				field[nextI][nextJ] = -Math.abs(areaNum);
				que.add(new Position(nextI, nextJ));
			}
		}
		maxArea = Math.max(maxArea, count);
	}
}

class Position {
	int i;
	int j;

	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}
}