package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N_and_M2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] comArr = new int[m];
		combination(comArr, n, m, 0, 0);// 0~n까지 있는 숫자중에 m개를 뽑는 경우
	}

	private static void combination(int[] comArr, int n, int r, int index, int target) {
		if (r == 0) {
			for (int i : comArr) {
				System.out.print(i + 1 + " ");
			}
			System.out.println();
			return;
		}
		if (target == n)
			return;

		comArr[index] = target;
		combination(comArr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(comArr, n, r, index, target + 1);// 안뽑는경우

	}
}
