package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {
	static int sum = 0;
	static int m = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] cardArr = new int[n];
		boolean[] visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cardArr[i] = Integer.parseInt(st.nextToken());
		}
		combination(cardArr, visited, 0, n, 3);
		System.out.println(sum);
	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	static void print(int[] arr, boolean[] visited, int n) {
		int tempSum = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				//System.out.print(arr[i] + " ");
				tempSum += arr[i];

			}
		}
		if (m - tempSum >= 0 && m - tempSum < m - sum) {
			sum = tempSum;
		}
		//System.out.println();
		//System.out.println(sum);
	}
}
