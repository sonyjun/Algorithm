package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Level3_3_1 {
	public static void main(String[] args) {
		System.out
				.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
		System.out.println("-----------------------------------");
		System.out.println(solution(5, new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 2, 3, 3 }, { 3, 1, 2 }, { 3, 0, 4 },
				{ 2, 4, 6 }, { 4, 0, 7 } }));

	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;// 초기값들 채워줌
		}
		Edge[] edgeArr = new Edge[costs.length];
		for (int i = 0; i < costs.length; i++) {
			edgeArr[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
		}
		Arrays.sort(edgeArr, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
		});

		for (int i = 0; i < edgeArr.length; i++) {
			// 정렬이 되어있으니 0번쨰 인덱스부터 탐색
			// 그룹이 사이클을 형성하지 않는지 확인하면서 추가.
			// 출발점과 도착점의 정점을 UNION을 통해 확인
			if (!findParent(parent, edgeArr[i].e1, edgeArr[i].e2)) {
				unionParent(parent, edgeArr[i].e1, edgeArr[i].e2);
				System.out.println(edgeArr[i].e1 + "," + edgeArr[i].e2 + " 연결완료");
				System.out.println(edgeArr[i].value);
				answer += edgeArr[i].value;
			}
		}

		for (int i : parent) {
			System.out.print(i + " ");
		}
		System.out.println();
		return answer;
	}

	public static int getParent(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return getParent(parent, parent[x]);
	}

	public static void unionParent(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if (aParent < bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
	}

	public static boolean findParent(int[] parent, int a, int b) {
		if (getParent(parent, a) == getParent(parent, b)) {
			return true;
		} else {
			return false;
		}
	}
}

class Edge {
	int e1;
	int e2;
	int value;

	public Edge(int a, int b, int value) {
		this.e1 = a;
		this.e2 = b;
		this.value = value;
	}
}
