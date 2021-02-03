package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 앱의 개수
		int m = Integer.parseInt(st.nextToken());// 필요한 바이트 크기.
		int[] memoryArr = new int[n + 1];// 메모리에 차지하는 바이트 크기.
		int[] costArr = new int[m + 1]; // 다시 활성화 시키는데 드는 비용.
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			memoryArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			costArr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[10000001];
		int sum = 0;
		for (int j = 1; j <= m; j++) {
			dp[j] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			sum += memoryArr[i];
			for (int j = m; j >= 1; j--) {
				if (j <= memoryArr[i]) { 
					// i번째 앱으로만 만들 수 있는 값에 대해 갱신해줌.
					// 다른 앱과의 조화를 이루어봤자 비용은 더 증가만 하기 때문에 비교할 필요 없음. 순수한 값만 비교한다.
					dp[j] = Math.min(dp[j], costArr[i]);
				} else if (j <= sum) {
					// i번째 앱보다 큰 공간을 만들어야 될 경우. i번째 앱을 비활성화 했을 때와 안했을 때를 비교해줌.
					dp[j] = Math.min(costArr[i] + dp[j - memoryArr[i]], dp[j]);
				}
			}
			// System.out.println();
		}
		System.out.println(dp[m]);
	}
}
