package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LongestNode {
	public static void main(String args[]) {
		LongestNodeSolution l = new LongestNodeSolution();
		System.out.println(l.solution(7,
				new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 }, { 5, 7 } }));
	}
}

class LongestNodeSolution {
	public int solution(int n, int[][] edge) {
		int[] distance = new int[n];
		int max = 0;
		boolean[][] adjArr = new boolean[n][n];
		boolean[] checked = new boolean[n];

		for (int i = 0; i < edge.length; i++) {
			adjArr[edge[i][0] - 1][edge[i][1] - 1] = true;
			adjArr[edge[i][1] - 1][edge[i][0] - 1] = true;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(0);
		checked[0] = true;
		int node;
		while (!que.isEmpty()) {
			node = que.poll();
			for (int i = 0; i < n; i++) {
				if (adjArr[node][i] == true && checked[i] == false) {
					checked[i] = true;
					distance[i] = distance[node] + 1;
					que.add(i);
				}
			}
		}
		int count = 0;
		for (int i : distance) {
			if (max < i) {
				max = i;
				count = 1;
			} else if (max == i) {
				count++;
			}
		}
		return count;
	}
}