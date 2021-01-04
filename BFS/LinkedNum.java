package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LinkedNum {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int[][] adjArr = new int[vertexNum + 1][vertexNum + 1];
		// +1을 했다는건 1번인덱스부터 쓰겟다는 얘기겠지~?
		boolean[] visited = new boolean[vertexNum + 1];

		for (int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjArr[x][y] = 1;
			adjArr[y][x] = 1;
		}
		int count = 0;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == false) {
				count++;
				BFS(adjArr, visited, i);
			}
		}
		System.out.println(count);
		/*for (int i = 1; i < adjArr.length; i++) {
			for (int j = 1; j < adjArr.length; j++) {
				System.out.print(adjArr[i][j]);
			}
			System.out.println();
		}*/

	}

	public static void BFS(int[][] adjArr, boolean[] visited, int startVertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		visited[startVertex] = true;
		que.add(startVertex);
		while (!que.isEmpty()) {
			int pollVertex = que.poll();
			for (int i = 1; i < adjArr[0].length; i++) {
				if (adjArr[pollVertex][i] == 1 && visited[i] == false) {
					// 해당 정점과 인접하면서도 방문하지 않은 정점을 que에 넣음. 즉, 연결되어있다는 얘기잖아,.
					visited[i] = true;
					que.add(i);// que에 들어가는건 다 시작정점과 인접한 녀석들임.
				}
			}
		}
	}
}
