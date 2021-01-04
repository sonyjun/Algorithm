package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] adjArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < inputStr.length(); j++) {
				adjArr[i][j] = Integer.parseInt(inputStr.charAt(j) + "");
			}
		}
		BFS(adjArr, 0, 0, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(adjArr[n-1][m-1]);
	}

	public static void BFS(int[][] adjArr, int i, int j, int count) {
		Queue<MazeItem> que = new LinkedList<MazeItem>();
		adjArr[i][j] = -1;
		que.add(new MazeItem(i, j, count));
		while (!que.isEmpty()) {
			MazeItem temp = que.poll();
			int tempI = temp.i;
			int tempJ = temp.j;
			int currentCount = temp.count;
			//System.out.println("몇번");
			// 1이면 방문하지 않은 곳.
			if (tempI - 1 >= 0 && adjArr[tempI - 1][tempJ] == 1) {
				adjArr[tempI - 1][tempJ] = currentCount + 1;
				que.add(new MazeItem(tempI - 1, tempJ, currentCount + 1));
			}

			if (tempJ - 1 >= 0 && adjArr[tempI][tempJ - 1] == 1) {
				adjArr[tempI][tempJ-1] = currentCount + 1;
				que.add(new MazeItem(tempI, tempJ - 1, currentCount + 1));
			}

			if (tempI + 1 < adjArr.length && adjArr[tempI + 1][tempJ] == 1) {
				adjArr[tempI + 1][tempJ] = currentCount + 1;
				que.add(new MazeItem(tempI + 1, tempJ, currentCount + 1));
			}

			if (tempJ + 1 < adjArr[0].length && adjArr[tempI][tempJ + 1] == 1) {
				adjArr[tempI][tempJ + 1] = currentCount + 1;
				que.add(new MazeItem(tempI, tempJ + 1, currentCount + 1));
			}

		}
	}
}

class MazeItem {
	int i;
	int j;
	int count;

	public MazeItem(int i, int j, int count) {
		this.i = i;
		this.count = count;
		this.j = j;
	}
}