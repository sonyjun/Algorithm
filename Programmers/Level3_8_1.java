package Programmers;

import java.util.ArrayList;

public class Level3_8_1 {
	public static void main(String[] args) {
		solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 },
				{ 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 3, 3, 6, 7 });
		// solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4
		// }, { 3, 5 }, { 4, 6 }, { 5, 6 },
		// { 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 4, 6, 5, 7 });
	}

	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] gps;

	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;
		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		gps = gps_log;
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
			// adjList[i].add(i);
		}
		for (int i = 0; i < edge_list.length; i++) {
			int v1 = edge_list[i][0];
			int v2 = edge_list[i][1];
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		visited[1] = true;
		DFS(gps_log[0], 0, "", k - 1, gps_log[gps_log.length - 1]);
		return answer;
	}

	public static void DFS(int vertex, int depth, String num, int endDepth, int endVertex) {
		if (depth == endDepth && vertex == endVertex) {
			System.out.print(num + vertex);
			System.out.println();
			return;
		}
		for (int i : adjList[vertex]) {
			if (visited[i] == false) {
				visited[i] = true;
				DFS(i, depth + 1, num + vertex, endDepth, endVertex);
				visited[i] = false;
			}
		}
	}
}
