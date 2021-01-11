package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Wire {
	static boolean[] check;
	static int[][] wireArr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		wireArr = new int[n + 1][2];
		check = new boolean[n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			wireArr[i][0] = left;
			wireArr[i][1] = right;
		}
		Arrays.sort(wireArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		/*for (int i = 1; i <= n; i++) {
			System.out.println(wireArr[i][0] + " " + wireArr[i][1]);
		}*/
		int[] dp = new int[n + 1]; // dp[i]는 i번째를 포함했을 때 갖을 수 있는 최대 전선의 갯수.
									// 왼쪽 전봇대를 기준으로 정렬을 해놓았다. 왼쪽 전선에 해당되는 오른쪽 선에 대한 기준을 새로 확립한다.
									// dp[i]는 1~i-1까지 자신보다 작은 값중 제일 큰 값을 더한 값이다.
									// 예를 들어, 오른쪽 전봇대가 8,2,9 이 나왔을 때, 실직적으로 1-8, 2-2 , 3-9로 연결된 상태이지.
									// 8이 나오고 다음 8보다 작은 2가 나온다면 8과 2는 겹치는 상태이다. 1-8, 2-2 전봇대 그려보면 알 것이다.
									// 8이 나오고 다음 8보다 큰 9가 나온다면 8과 9는 겹치지 않는다. 1-8, 3-9 전봇대를 그려보면 알 것이다.
									// 이런식으로 증가하는 부분 수열이 가장 클 때를 구하면 되는 것이다.
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < i; j++) {
				if (wireArr[j][1] < wireArr[i][1]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += 1;
		}
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(n-max);
	}
}
