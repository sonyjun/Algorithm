package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	public static void main(String[] args) {
		Solution가장먼노드 s = new Solution가장먼노드();
		System.out.println(
				s.solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } }));
	}
}

class Solution가장먼노드 {
	ArrayList<Integer>[] adjList;
	int[] distance;
	boolean[] visited;

	public int solution(int n, int[][] edge) {
		adjList = new ArrayList[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edge.length; i++) {
			adjList[edge[i][0]].add(edge[i][1]);
			adjList[edge[i][1]].add(edge[i][0]);
		}
		int maxDistance = BFS(1);
		int answer = 0;
		for (int i = 1; i < distance.length; i++) {
			if (maxDistance == distance[i]) {
				answer++;
			}
		}
		return answer;
	}

	public int BFS(int startVertex) {
		int maxDinstance = 0;
		Queue<Info> que = new LinkedList<Info>();
		que.add(new Info(startVertex, 0));
		visited[startVertex] = true;
		while (!que.isEmpty()) {
			Info pollInfo = que.poll();
			maxDinstance = Math.max(maxDinstance, pollInfo.distance);
			for (int adj : adjList[pollInfo.vertex]) {
				if (visited[adj] == false) {
					visited[adj] = true;
					distance[adj] = pollInfo.distance + 1;
					que.add(new Info(adj, pollInfo.distance + 1));
				}
			}
		}
		return maxDinstance;
	}
}

class Info {
	int vertex;
	int distance;

	public Info(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
}