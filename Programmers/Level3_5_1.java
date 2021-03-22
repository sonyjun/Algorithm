package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level3_5_1 {
	static ArrayList<Integer>[] adjList;
	static int[][] resultArr;
	static boolean[] visited;

	public static void main(String[] args) {
		solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } });
	}

	public static int solution(int n, int[][] results) {
		int answer = 0;
		adjList = new ArrayList[n + 1];
		resultArr = new int[n + 1][2];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		// 인접 리스트 구성.
		for (int i = 0; i < results.length; i++) {
			adjList[results[i][1]].add(results[i][0]);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			BFS(i);
		}

		for (int i = 1; i < resultArr.length; i++) {
			if (resultArr[i][1] == n - 1) {
				answer++;
			}
		}
		return answer;
	}

	public static void BFS(int vertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(vertex);
		int count = 0;// 나보다 잘하는 사람의 수.
		while (!que.isEmpty()) {
			int pollNum = que.poll();
			for (int i : adjList[pollNum]) {
				if (visited[i] == false) {
					visited[i] = true;
					resultArr[i][1] += 1;// 나보다 잘하는 사람, 즉, 나랑 승부를 지을 수 있는 사람 체크해줌.
					count++;
					que.add(i);
				}
			}
		}
		resultArr[vertex][1] += count;
	}
}
