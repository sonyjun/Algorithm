package Programmers;

import java.util.PriorityQueue;

public class Delivery {
	static int INF = 10000000;
	static int a[][];
	static boolean[] visited; // 방문여부
	static int[] distance;// 거리
	static PriorityQueue<Node> que;

	public static void main(String[] args) {
		System.out.println(solution(5,
				new int[][] { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } }, 3));
		System.out.println(solution(6, new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 },
				{ 3, 5, 3 }, { 5, 6, 1 } }, 4));

	}

	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		que = new PriorityQueue<Node>();
		visited = new boolean[N];
		distance = new int[N];
		a = new int[N][N];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i != j) {
					a[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < road.length; i++) {
			int v1 = road[i][0] - 1;
			int v2 = road[i][1] - 1;
			a[v1][v2] = Math.min(a[v1][v2], road[i][2]);
			a[v2][v1] = Math.min(a[v2][v1], road[i][2]);
		}
		dijkstra(0);
		//System.out.println("K : " + K);
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] <= K) {
				answer++;
			}
		}
		return answer;
	}

	public static void dijkstra(int start) {
		for (int i = 0; i < distance.length; i++) {
			que.add(new Node(i, a[start][i]));
			distance[i] = a[start][i];
		}
		visited[start] = true;
		while (!que.isEmpty()) {
			Node node = que.poll();
			if (visited[node.vertex] == false) {// 방문한 녀석이 작을 수도 있으니.. 결국 방문한 녀석들껏도 나오겟지.
				visited[node.vertex] = true;// 우선순위 큐에서 나온 녀석이 방문안한 녀석이면 방문.
				for (int j = 0; j < distance.length; j++) {// 그 녀석이랑 인접하고 갱신할 필요 있다면.
					if (visited[j] == false) {
						if (a[node.vertex][j] + distance[node.vertex] < distance[j]) {
							distance[j] = a[node.vertex][j] + distance[node.vertex];
							que.add(new Node(j, distance[j]));
							// 새롭게 갱신된 친구를 넣어 줘야지. 기존 것보다 갱신되었으니.
						}
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int vertex;
	int value;

	Node(int vertex, int value) {
		this.value = value;
		this.vertex = vertex;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}