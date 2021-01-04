package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//앞에서 더해온 값들을 더하는게 이득일지, 본인을 시작으로 해서 새로 시작하는게 이득일지 경우를 따짐.//
// dp[i]는 i번째 숫자를 포함하여 얻을 수 있는 최대 값.
public class ContinuousSum {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] numArr = new int[num + 1];
		int[] dp = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		dp[1] = numArr[1];
		int maxNum = dp[1];
		for (int i = 2; i < numArr.length; i++) {
			dp[i] = Math.max(dp[i - 1] + numArr[i], numArr[i]);
			if (maxNum < dp[i]) {
				maxNum = dp[i];
			}
		}
		System.out.println(maxNum);
	}
}
