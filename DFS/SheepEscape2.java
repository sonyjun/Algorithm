package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
4
S 100 3
W 50 1
S 10 1
 */
public class SheepEscape2 {
	static int totalSheepNum = 0;
	static int[] countList;
	static char[] charList;
	static LinkedList<Integer>[] adjList;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int islandNum = Integer.parseInt(br.readLine());
		adjList = new LinkedList[islandNum + 1];
		countList = new int[islandNum + 1];
		charList = new char[islandNum + 1];
		StringTokenizer st;
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 1; i < adjList.length - 1; i++) {
			st = new StringTokenizer(br.readLine());
			char who = st.nextToken().charAt(0);
			int count = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());

			countList[i + 1] = count;
			charList[i + 1] = who;
			adjList[parent].add(i+1);
		}
		System.out.println(postOrder(1));
	}

	public static long postOrder(int visitVertex) {
		// System.out.println("몇번");
		long sum = 0;
		for (int i : adjList[visitVertex]) {
			sum += postOrder(i);
		}
		if (charList[visitVertex] == 'S') {
			return sum + countList[visitVertex];
		} else {
			return (sum - countList[visitVertex]) >= 0 ? sum - countList[visitVertex] : 0;
		}
	}
}