package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
	static int[] parent;

	public static void main(String[] args) {
		System.out
				.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
		System.out.println(solution(15, new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 2, 3, 3 }, { 3, 1, 2 }, { 3, 0, 4 },
				{ 2, 4, 6 }, { 4, 0, 7 } }));

	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}

		});
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < costs.length; i++) {
			if (!sameParent(costs[i][0], costs[i][1])) {
				makeSet(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}
		}
		return answer;
	}

	public static int getParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		return getParent(parent[x]);
	}

	public static void makeSet(int x, int y) {
		if (getParent(x) < getParent(y)) {
			parent[getParent(y)] = getParent(x);
		} else {
			parent[getParent(x)] = getParent(y);
		}
	}

	public static boolean sameParent(int x, int y) {
		if (getParent(x) == getParent(y)) {
			return true;
		}
		return false;
	}
}
