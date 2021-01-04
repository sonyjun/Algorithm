package DFS_BFS;

import java.util.Iterator;
import java.util.LinkedList;

public class Network {
	public static void main(String args[]) {
		NetworkSolution n = new NetworkSolution();
		n.BFSsolution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } });
		n.BFSsolution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } });

		//n.DFSsolution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } });
		//n.DFSsolution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } });
	}
}

class NetworkSolution {
/*	public int BFSsolution(int n, int[][] computers) {
		int netCount = 0;
		LinkedList<Integer>[] adj = new LinkedList[n];
		for (int i = 0; i < computers.length; i++) {
			adj[i] = new LinkedList<Integer>();
			for (int j = 0; j < computers[0].length; j++) {
				if (computers[i][j] == 1 && i != j) {
					adj[i].add(j);
				}
			}
		}

		boolean[] visited = new boolean[n];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				netCount++;
				queue.add(i);
				while (!queue.isEmpty()) {// 하나의 vertex에 대해 깊이 우선탐색 한번 한거임.
					int v = queue.poll();
					visited[v] = true;
					Iterator<Integer> iter = adj[v].listIterator();
					while (iter.hasNext()) {
						int next = iter.next();
						if (visited[next] == false) {
							visited[next] = true;
							queue.add(next);
						}
					}
				}
			}
		}

		// System.out.println(netCount);
		return netCount;
	}*/

	public int BFSsolution(int n, int[][] computers) {
		int netCount = 0;
		boolean[] visited = new boolean[n];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {//정점을 모두 방문했는지 확인하기 위해.
			if (visited[i] == false) {
				netCount++;
				queue.add(i);
				while (!queue.isEmpty()) {// 하나의 vertex에 대해 깊이 우선탐색 한번 한거임.
					int v = queue.poll();
					visited[v] = true;
					for(int j = 0 ; j < n ; j++) {
						if(computers[v][j] == 1 && visited[j] == false) {
							queue.add(j);
						}
					}
				}
			}
		}
		return netCount;
	}
	
	public int DFSsolution(int n, int[][] computers) {
		int netCount = 0;
		boolean[] checked = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (checked[i] == false) {// 방문안한 친구들 깊이 우선탐색 실시.
				netCount++;
				dfs(computers, checked, i);
			}
		}
		return netCount;
	}

	public void dfs(int[][] computers, boolean[] checked, int start) {
		checked[start] = true;
		for (int i = 0; i < computers.length; i++) {
			//System.out.println("i: "+start+" j : "+i);
			if (computers[start][i] == 1 && checked[i] == false) {
				dfs(computers, checked, i);
			}
		}
	}
}