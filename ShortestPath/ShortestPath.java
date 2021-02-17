package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath {
	static int[] distance;
	static boolean[] visited;
	static LinkedList<Edge>[] adjList;
	static int INF = 300001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		distance = new int[v + 1];
		Arrays.fill(distance, INF);
		visited = new boolean[v + 1];
		adjList = new LinkedList[v + 1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new LinkedList();
		}
		int start = Integer.parseInt(br.readLine());
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			adjList[e1].add(new Edge(e2, vertex));// 방향그래프.
		}
		dijstra(start);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (distance[i] > 300000) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i] + "\n");
			}
		}
		System.out.println(sb);

	}

	public static void dijstra(int start) {
		PriorityQueue<Edge> que = new PriorityQueue<Edge>();
		que.add(new Edge(start, 0));
		distance[start] = 0;
		while (!que.isEmpty()) {
			Edge pollEdge = que.poll();// Queue에 들어가는 애들은 현재 distance에서 제일 작은 비용을 뽑아내기 위함임.
			if (!visited[pollEdge.vertex]) {
				visited[pollEdge.vertex] = true;
				for (Edge e : adjList[pollEdge.vertex]) { //실제 꺼내온 정점을 지나가면 더 비용이 절감되는지는 인접리스트를 통해 확인.
					if (distance[pollEdge.vertex] + e.value < distance[e.vertex]) {
						// 현재 방문한 녀석까지 오는 거리 + 방문한 녀석부터 인접한 녀석 e까지 가는데 가는 비용 < 원래 e까지 가는데 드는 비용
						distance[e.vertex] = distance[pollEdge.vertex] + e.value;
						que.add(new Edge(e.vertex, distance[e.vertex]));//갱신이 된 녀석들만 넣음.
					}
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int vertex;
	int value;

	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}
