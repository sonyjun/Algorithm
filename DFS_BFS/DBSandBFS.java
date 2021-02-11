package DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DBSandBFS {
	static boolean[] visited;
	static BufferedWriter bw;
	// static LinkedList<Integer>[] adjArr;
	static int[][] adjArr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int startVertex = Integer.parseInt(st.nextToken());
		// adjArr = new LinkedList[vertexNum + 1];
		adjArr = new int[vertexNum + 1][vertexNum + 1];
		for (int i = 1; i < adjArr.length; i++) {
			// adjArr[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			adjArr[left][right] = 1;
			adjArr[right][left] = 1;
		}
		

		visited = new boolean[vertexNum + 1];
		DFS(startVertex);
		sb.append("\n");
		visited = new boolean[vertexNum + 1];
		BFS(startVertex);
		System.out.println(sb);
	}

	public static void BFS(int startVertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(startVertex);
		visited[startVertex] = true;
		while (!que.isEmpty()) {
			int pollNum = que.poll();
			sb.append(pollNum + " ");
			for (int i = 1; i < adjArr.length; i++) {
				if (visited[i] == false && adjArr[pollNum][i] == 1) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
		sb.append("\n");
	}

	public static void DFS(int startVertex) {
		visited[startVertex] = true;
		sb.append(startVertex + " ");
		for (int i = 1; i < adjArr.length; i++) {
			if (visited[i] == false && adjArr[startVertex][i] == 1) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
