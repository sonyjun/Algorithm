package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakery {
	static int pipeCount = 0;
	static int[] dI = { -1, 0, 1 };
	static int[] dJ = { 1, 1, 1 };
	static boolean isSuccess = false;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'x') {
					field[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			field[i][0] = 3;
			isSuccess = false;
			DFS(field, i, 0);
		}
		System.out.println(pipeCount);
		/*
		 * (for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) {
		 * System.out.print(field[i][j] + " "); } System.out.println(); }
		 */
	}

	public static void DFS(int[][] field, int startI, int startJ) {
		if (startJ == field[0].length - 1) {
			pipeCount++;
			isSuccess = true;
			return;
		}
		// isSuccess는 백트래킹의 원리. 나는 경우의 수를 따지면서 목표지점까지 간다.
		// 하지만 목표지점 만날때까지 왓던 길은 모두 다 쓸모 없는 길이다. 내가 가보니 막다른 길이더라..
		// 너희는 똑같은 실수를 반복하지 않게하기위해 흔적을 남기겠다.
		// 1. DFS를 통해 오른쪽 위,오른쪽,오른쪽 아래를 순서로 탐색을 시작한다.
		// 2. 오른쪽 위로 쭉 가던 중 막다른길이 나왔다. 그럼 오른쪽으로 탐색한다. 이런 과정을 반복한다.
		// 3. 목표지점에 도달 했을 경우. 이제까지 지나온 길의 흔적은 나두고, 이후에 탐색은 종료한다.
		// 이후 탐색이라고 하면 오른쪽위 -> 오른쪽 -> 오른쪽 아래 이런 과정의 반복문이 종료되는 것이다.
		for (int i = 0; i < 3; i++) {
			int nextI = startI + dI[i];
			int nextJ = startJ + dJ[i];

			// 범위 밖 패스
			if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
				continue;
			}
			// 0이면 방문
			if (field[nextI][nextJ] == 0) {
				field[nextI][nextJ] = 3;
				DFS(field, nextI, nextJ);
				if (isSuccess == true) {
					return;
				}
			}
		}
	}
}
