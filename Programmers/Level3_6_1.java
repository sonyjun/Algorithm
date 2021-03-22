package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level3_6_1 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] dist;
	static int maxDist = 0;

	public static void main(String[] args) {
		solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } });
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];// 1과의 각 거리를 나타냄.

		// 연결리스트 초기화
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		// 연결리스트로 그래프 구성
		for (int i = 0; i < edge.length; i++) {
			int v1 = edge[i][0];
			int v2 = edge[i][1];
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		BFS(1);
		for (int i = 0; i < dist.length; i++) {
			if(maxDist == dist[i]) {
				answer++;
			}
		}
		return answer;
	}

	public static void BFS(int vertex) {
		Queue<TNode> que = new LinkedList<TNode>();
		que.add(new TNode(vertex, 0));
		visited[vertex] = true;
		while (!que.isEmpty()) {
			TNode pollVertex = que.poll();
			maxDist = pollVertex.dist;
			dist[pollVertex.vertex] = pollVertex.dist;
			for (int i : adjList[pollVertex.vertex]) {
				if (visited[i] == false) {
					visited[i] = true;
					que.add(new TNode(i, pollVertex.dist + 1));
				}
			}
		}
	}
}

class TNode {
	int vertex;
	int dist;

	public TNode(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}
}
