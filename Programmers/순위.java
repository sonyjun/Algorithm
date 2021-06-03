package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 순위 {
	public static void main(String[] args) {
		Solution순위 s1 = new Solution순위();
		System.out.println(s1.solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
	}
}

class Solution순위 {
	int[] canWin;
	int[] canLose;
	boolean[] visited;
	ArrayList<Integer>[] adjList;

	public int solution(int n, int[][] results) {
		int answer = 0;
		adjList = new ArrayList[n + 1];
		canWin = new int[n + 1];
		canLose = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < results.length; i++) {
			adjList[results[i][1]].add(results[i][0]);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			BFS(i);
		}
		for (int i = 1; i <= n; i++) {
			if (canWin[i] + canLose[i] == n - 1) {
				answer++;
			}
		}
		return answer;
	}

	public void BFS(int startVertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(startVertex);
		visited[startVertex] = true;
		while (!que.isEmpty()) {
			int pollVertex = que.poll();
			for (int adj : adjList[pollVertex]) {
				if (visited[adj] == false) {
					visited[adj] = true;
					canWin[adj] += 1;
					canLose[startVertex] += 1;
					que.add(adj);
				}
			}
		}
	}
}