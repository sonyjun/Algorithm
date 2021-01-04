package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class KinShip {
	static int personNum = 0;
	static int answer = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		personNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startN = Integer.parseInt(st.nextToken());
		int endN = Integer.parseInt(st.nextToken());
		int inputNum = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] adjList = new LinkedList[personNum + 1];
		boolean[] visited = new boolean[personNum + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < inputNum; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			adjList[parent].add(child);
			adjList[child].add(parent);
		}
		visited[startN] = true;
		DFS(adjList, startN, endN, 0, visited);
		if (visited[endN] == false) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void DFS(LinkedList<Integer>[] adjList, int visitVertex, int endN, int count, boolean[] visited) {
		if (visitVertex == endN) {
			answer = count;
			return;
		}
		for (int i = 0; i < adjList[visitVertex].size(); i++) {
			int adjVertex = adjList[visitVertex].get(i);
			if (visited[adjVertex] == false) {
				visited[adjVertex] = true;
				DFS(adjList, adjVertex, endN, count + 1, visited);
			}
		}
	}
}
