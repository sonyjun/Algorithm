package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_and_M4 {
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] recomArr = new int[m];
		sb = new StringBuilder();
		reCombination(recomArr, n, m, 0, 0);// 0~n까지 있는 숫자중에 m개를 뽑는 경우
		System.out.println(sb);
	}

	private static void reCombination(int[] reComArr, int n, int r, int index, int target) {
		if (r == 0) {
			for (int i : reComArr) {
				sb.append(i + 1 + " ");
			}
			sb.append("\n");
			return;
		}
		if (target == n)
			return;

		reComArr[index] = target;
		reCombination(reComArr, n, r - 1, index + 1, target);// 뽑는경우
		reCombination(reComArr, n, r, index, target + 1);// 안뽑는경우

	}
}
