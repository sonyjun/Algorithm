package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Hacking {
	static int[] maxDistance = new int[10001];
	static ArrayList<Integer>[] adjList = new ArrayList[10001];
	static boolean[] visited = new boolean[10001];
	// int배열 형태의 커서보다는 boolean배열을 이용해서 접근하는게 훨씬 빠르다...
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x].add(y);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[10001];
			DFS(i);
		}

		// System.out.println(totalMax);
		int totalMax = 0;
		for (int i = 1; i <= n; i++) {
			if (totalMax < maxDistance[i]) {
				totalMax = maxDistance[i];
			}
		}
		for (int i = 1; i <= n; i++) {
			if (totalMax == maxDistance[i]) {
				System.out.print(i + " ");
			}
		}
	}

	public static void DFS(int visitVertex) {
		visited[visitVertex] = true;
		for (int i : adjList[visitVertex]) {
			if (!visited[i]) {
				maxDistance[i]++;
				DFS(i);
			}
		}
	}
}
