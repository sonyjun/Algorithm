package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class SelectNum {
	static TreeSet<Integer> ts3 = new TreeSet<Integer>();
	static int[] adjArr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		adjArr = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			adjArr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < visited.length; i++) {
			// 각 정점마다 DFS호출.
			DFS(adjArr, i, i, 1);
		}
		Iterator<Integer> iter = ts3.iterator();
		System.out.println(ts3.size());
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public static void DFS(int[] adjArr, int start, int end, int count) {
		if (adjArr[start] == end) {// 매칭된 숫자를 통해 계속 따라가면 본인에게 도달이 가능한가? 즉 사이클 형성이 가능한가.. 이게 집합의 묘미임.
			// 집합을 이룬다 결국 돌고 돌아 본인에게 도달이 가능하다.
			ts3.add(end);
			return;
		}
		if (count > adjArr.length) {
			return;
		}
		DFS(adjArr, adjArr[start], end, count + 1);
	}
}
