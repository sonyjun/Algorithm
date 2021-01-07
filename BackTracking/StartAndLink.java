package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink {
	static int[][] teamPower;
	static int maxIndex = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] powerArr = new int[num + 1][num + 1];
		teamPower = new int[200000][num / 2];
		int[] powerSum = new int[200000];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < num; j++) {
				powerArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] comArr = new int[num / 2];
		combination(comArr, num, num / 2, 0, 0);
		int gap = Integer.MIN_VALUE;
		for (int i = 0; i < maxIndex / 2 + 1; i++) {
			int sum = 0;
			for (int j = 0; j < num / 2; j++) {
				
			}
		}
		for (int i = 0; i < maxIndex; i++) {
			for (int j = 0; j < num / 2; j++) {
				System.out.print(teamPower[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void combination(int[] comArr, int n, int r, int index, int target) {
		if (r == 0) {
			for (int i : comArr) {
				// System.out.print(i + 1 + " ");
			}
			// System.out.println();
			for (int i = 0; i < comArr.length; i++) {
				teamPower[maxIndex][i] = comArr[i] + 1;
			}
			maxIndex++;
			return;
		}
		if (target == n)
			return;

		comArr[index] = target;
		combination(comArr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(comArr, n, r, index, target + 1);// 안뽑는경우

	}
}
