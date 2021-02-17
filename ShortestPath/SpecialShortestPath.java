package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecialShortestPath {
	static int[] distance;
	static boolean[] visited;
	static LinkedList<EdgeS>[] adjList;
	static int INF = 1000001;

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
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			adjList[e1].add(new EdgeS(e2, vertex));// 방향그래프.
			adjList[e2].add(new EdgeS(e1, vertex));// 방향그래프.
		}
		st = new StringTokenizer(br.readLine());
		int firstEdge = Integer.parseInt(st.nextToken());
		int secondEdge = Integer.parseInt(st.nextToken());

		dijstra(1);
		int firstRootStart = distance[firstEdge];
		int secondRootStart = distance[secondEdge];

		distance = new int[v + 1];
		Arrays.fill(distance, INF);
		visited = new boolean[v + 1];
		dijstra(firstEdge);
		int secondRootEnd = distance[v];
		int commonRoot = distance[secondEdge];

		distance = new int[v + 1];
		Arrays.fill(distance, INF);
		visited = new boolean[v + 1];
		dijstra(secondEdge);
		int firstRootEnd = distance[v];
		int min = Math.min(firstRootStart + firstRootEnd + commonRoot, secondRootStart + secondRootEnd + commonRoot);
		if(min > 1000000){
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	public static void dijstra(int start) {
		PriorityQueue<EdgeS> que = new PriorityQueue<EdgeS>();
		que.add(new EdgeS(start, 0));
		distance[start] = 0;
		while (!que.isEmpty()) {
			EdgeS pollEdgeS = que.poll();// Queue에 들어가는 애들은 현재 distance에서 제일 작은 비용을 뽑아내기 위함임.
			if (!visited[pollEdgeS.vertex]) {
				visited[pollEdgeS.vertex] = true;
				for (EdgeS e : adjList[pollEdgeS.vertex]) { // 실제 꺼내온 정점을 지나가면 더 비용이 절감되는지는 인접리스트를 통해 확인.
					if (distance[pollEdgeS.vertex] + e.value < distance[e.vertex]) {
						// 현재 방문한 녀석까지 오는 거리 + 방문한 녀석부터 인접한 녀석 e까지 가는데 가는 비용 < 원래 e까지 가는데 드는 비용
						distance[e.vertex] = distance[pollEdgeS.vertex] + e.value;
						que.add(new EdgeS(e.vertex, distance[e.vertex]));// 갱신이 된 녀석들만 넣음.
					}
				}
			}
		}
	}
}

class EdgeS implements Comparable<EdgeS> {
	int vertex;
	int value;

	public EdgeS(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(EdgeS o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}

/*
4 3
3 4 1
1 3 5
1 4 4
2 3
 */
