package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestPath2 {
	static int number = 6;
	static int INF = 10000000;
	static int adjArr[][];
	static boolean[] visited; // 방문여부
	static int[] distance; // 거리

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		distance = new int[v + 1];
		visited = new boolean[v + 1];
		adjArr = new int[v + 1][v + 1];
		int start = Integer.parseInt(br.readLine());
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			adjArr[e1][e2] = vertex;// 방향성 그래프.
		}
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i != j && adjArr[i][j] == 0) {
					adjArr[i][j] = INF;
				}
			}
		}
		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if(distance[i] > 300000) {
				sb.append("INF\n");
			}else {
				sb.append(distance[i]+"\n");
			}
		}
		System.out.println(sb);
	}

	public static int getSmallIndex() {

		int smallValue = Integer.MAX_VALUE;
		int smallIndex = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] < smallValue && !visited[i]) {
				smallValue = distance[i];
				smallIndex = i;
			}
		}
		return smallIndex;
	}

	// 시작 정점으로 distance 초기화.
	// 인접 정점 중 가장 거리 짧은 것 방문. (거리가 짧은 걸 방문해야 당연히 갱신 가능성 있지..)
	// 명심해야 될 건 특정 정점 하나와의 거리의 최소값들을 구하는 것임.
	public static void dijkstra(int start) {
		for (int i = 1; i < distance.length; i++) {
			distance[i] = adjArr[start][i];
		}
		visited[start] = true;
		for (int i = 1; i < number-1; i++) {//제일 처음 방문한것과 마지막 것은 방문하지 않아도 됨.
			int smallIndex = getSmallIndex();
			visited[smallIndex] = true;// 제일 작은 놈은 이제 최종 최소 값이 정해진 것임.
										// 나머지 경로를 타면 더 커진다는 말이니까.
			for (int j = 1; j < distance.length; j++) {
				if (visited[j] == false) {
					if (adjArr[smallIndex][j] + distance[smallIndex] < distance[j]) {
						distance[j] = adjArr[smallIndex][j] + distance[smallIndex];
					}
				}
			}
		}
	}
}
