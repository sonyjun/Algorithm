package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class EdgeT {
	int vertex;
	int distance;

	public EdgeT(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
}

public class TreeDiameter2 {
	static int maxNum = 0;
	static int longVertex = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<EdgeT>[] adjList = new LinkedList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<EdgeT>();
		}
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int currentVertex = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int adjVertex = Integer.parseInt(st.nextToken());
				//System.out.println(currentVertex+", "+adjVertex);
				if (adjVertex == -1) {
					break;
				}
				int adjDistance = Integer.parseInt(st.nextToken());
				//System.out.println(adjDistance);
				adjList[currentVertex].add(new EdgeT(adjVertex, adjDistance));
			}
		}
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		DFS(adjList, 1, visited, 0);// 루트에서 제일 먼 정점 찾기.
		visited = new boolean[n + 1];
		visited[longVertex] = true;
		DFS(adjList, longVertex, visited, 0);// 루트에서 제일 먼 정점 찾기.
		System.out.println(maxNum);
		// System.out.println(longVertex);
	}

	public static void DFS(LinkedList<EdgeT>[] adjList, int visitVertex, boolean[] visited, int cost) {
		if (maxNum < cost) {
			maxNum = cost;
			longVertex = visitVertex;
		}
		for (int i = 0; i < adjList[visitVertex].size(); i++) {
			int adjVertex = adjList[visitVertex].get(i).vertex;
			if (visited[adjVertex] == false) {
				visited[adjVertex] = true;
				DFS(adjList, adjVertex, visited, cost + adjList[visitVertex].get(i).distance);
			}
		}
	}
}