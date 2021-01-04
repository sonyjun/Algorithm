package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Edge {
	int vertex;
	int distance;

	public Edge(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
}

public class TreeDiameter {
	static int maxNum = 0;
	static int longVertex = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Edge>[] adjList = new LinkedList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[x].add(new Edge(y, cost));
			adjList[y].add(new Edge(x, cost));
		}
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		DFS(adjList, 1, visited, 0);// 루트에서 제일 먼 정점 찾기.
		visited = new boolean[n + 1];
		visited[longVertex] = true;
		DFS(adjList, longVertex, visited, 0);// 루트에서 제일 먼 정점 찾기.
		System.out.println(maxNum);
		//System.out.println(longVertex);
	}

	public static void DFS(LinkedList<Edge>[] adjList, int visitVertex, boolean[] visited, int cost) {
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