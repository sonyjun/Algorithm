package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N_and_M3 {
	static StringBuilder sb;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> rePerArr = new LinkedList<Integer>();
		sb = new StringBuilder();
		rePermutation(n, m, rePerArr);// 0~n까지 있는 숫자중에 m개를 뽑는 경우
		System.out.println(sb);
	}

	private static void rePermutation(int n, int r, LinkedList<Integer> rePerArr) {
		if (rePerArr.size() == r) {
			for (int i : rePerArr) {
				sb.append(i+1+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			rePerArr.add(i);
			rePermutation(n, r, rePerArr);
			rePerArr.removeLast();

		}

	}
}
