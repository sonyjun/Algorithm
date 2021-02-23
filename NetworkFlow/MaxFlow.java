package NetworkFlow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//네트워크 플로우. 양방향이라면 양쪽에 추가해주어야함. 
//가능한 경로를 다 따져보면서 결국 조화를 이루어 최적의 값을 얻을 거임.
//양방향인것 상관없이 양쪽에 추가해주면 음의 유량 양쪽에 적용이 되므로 그대로 사용가능.

//양방향이라면 일단 capacity의 양쪽에 추가해주는 것을 잊지말자. 
//또 두 정점사이의 간선이 많을 수도 있으니. 누적시켜주는 것도 잊지 말자.

public class MaxFlow {// 최대 유량. 백준 6086번.
	static LinkedList<Integer>[] adjList;
	static int[] prevAndVisited;
    static int [][] flow;
    static int [][] capacity;
    static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		adjList = new LinkedList[53];
		prevAndVisited = new int[53];
		flow = new int[53][53];
		capacity = new int[53][53];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = AlphaToIndex(st.nextToken().charAt(0));
			int end = AlphaToIndex(st.nextToken().charAt(0));
			int capa = Integer.parseInt(st.nextToken());
			adjList[start].add(end);
			adjList[end].add(start);
			capacity[start][end] += capa;
			capacity[end][start] += capa;
		}
		int startVertex = AlphaToIndex('A');
		int endVertex = AlphaToIndex('Z');
		maxFlow(startVertex, endVertex);
		System.out.println(result);
	}

	public static int AlphaToIndex(char ch) {
		if (ch <= 'Z')
			return ch - 'A' + 1;
		return ch - 'a' + 27;
	}
	public static void maxFlow(int start, int end) {
		Queue<Integer> que;
		while (true) {
			Arrays.fill(prevAndVisited, -1);
			prevAndVisited[start] = 0;
			que = new LinkedList<Integer>();
			que.add(start);
			while (!que.isEmpty()) {
				int pollNum = que.poll();
				for (int i = 0; i < adjList[pollNum].size(); i++) {
					int adjVertex = adjList[pollNum].get(i);
					if (capacity[pollNum][adjVertex] - flow[pollNum][adjVertex] > 0
							&& prevAndVisited[adjVertex] == -1) {
						que.add(adjVertex);
						prevAndVisited[adjVertex] = pollNum;
						if (adjVertex == end)
							break;
						// 마지막까지 도달했다면, 새로운 경로 하나를 찾은 거임.
						// 이 경로에 대한 걸 갱신시켜주고 새로 돌려야지
					}
				}
			}
			if (prevAndVisited[end] == -1) { // 경로를 차지 못한 경우임, 즉 도착 정점까지 도달할 수 있는 경로가 없는 경우.
				break;
			}
			int minflow = Integer.MAX_VALUE;
			for (int i = end; i != start; i = prevAndVisited[i]) {// 찾은 경로에 대해서 최소값을 찾아 그 값을 흘려보내줌
				minflow = Math.min(minflow, capacity[prevAndVisited[i]][i] - flow[prevAndVisited[i]][i]); // i가 그 경로를 //
																											// 따라가는 지표임.
			}

			for (int i = end; i != start; i = prevAndVisited[i]) {// 찾은 경로에 대해서 최소값을 찾아 그 값을 흘려보내줌
				flow[prevAndVisited[i]][i] += minflow; // i가 그 경로를 따라가는 지표임.
				flow[i][prevAndVisited[i]] -= minflow;
			}
			result += minflow;
		}
	}

}
