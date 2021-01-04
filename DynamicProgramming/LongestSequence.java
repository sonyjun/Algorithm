package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSequence {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sequenceNum = Integer.parseInt(br.readLine());
		int[] sequenceArr = new int[sequenceNum + 1];
		int[] dp = new int[sequenceNum + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < sequenceNum + 1; i++) {
			sequenceArr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = 1;
		int maxLength = 1;
		for (int i = 2; i < dp.length; i++) {
			int here = 0;
			int temp = sequenceArr[i];
			for (int j = 1; j < i; j++) {
				if (temp > sequenceArr[j]) {
					here = Math.max(dp[j], here);
				}
			}
			dp[i] = here + 1;
			maxLength = Math.max(maxLength, dp[i]);
		}
		System.out.println(maxLength);
	}
}
