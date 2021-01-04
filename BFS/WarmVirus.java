package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WarmVirus {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vertexNum = Integer.parseInt(br.readLine());
		int edgeNum = Integer.parseInt(br.readLine());
		int[][] adjArr = new int[vertexNum + 1][vertexNum + 1];
		boolean[] visited = new boolean[vertexNum + 1];
		StringTokenizer st;
		for (int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjArr[x][y] = 1;
			adjArr[y][x] = 1;
		}
		System.out.println(BFS(adjArr, visited, 1));
		/*
		 * for (int i = 1; i < adjArr.length; i++) { for (int j = 1; j < adjArr.length;
		 * j++) { System.out.print(adjArr[i][j]); } System.out.println(); }
		 */

	}

	public static int BFS(int[][] adjArr, boolean[] visited, int startVertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		visited[startVertex] = true;
		que.add(startVertex);
		int virusComNum = 0;
		while (!que.isEmpty()) {
			int pollVertex = que.poll();
			for (int i = 1; i < adjArr[0].length; i++) {
				if (adjArr[pollVertex][i] == 1 && visited[i] == false) {
					visited[i] = true;
					que.add(i);
					virusComNum++;
				}
			}
		}
		return virusComNum;
	}
}
