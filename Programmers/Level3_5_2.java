package Programmers;

public class Level3_5_2 {
	public static void main(String[] args) {

		//solution(new int[] { 9, -1, -5 });
		solution(new int[] { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 });
	}

	public static int solution(int[] a) {
		int answer = 0;
		int minNum = Integer.MAX_VALUE;
		int minNumIdx = 0;
		int[] dp = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if (minNum > a[i]) {
				minNum = a[i];
				minNumIdx = i;
				dp[i] = minNum;
			}
		}
		minNum = Integer.MAX_VALUE;
		for (int i = 0; i < minNumIdx; i++) {
			if (minNum > a[i]) {
				minNum = a[i];
			}
			dp[i] = minNum;
		}

		minNum = Integer.MAX_VALUE;
		for (int i = a.length - 1; i > minNumIdx; i--) {
			if (minNum > a[i]) {
				minNum = a[i];
			}
			dp[i] = minNum;
		}
		for (int i = 0; i < a.length; i++) {
			boolean isOk = true;
			if (minNumIdx > i) {
				if (a[i] > dp[i]) {
					isOk = false;
				}
			} else {
				if (a[i] > dp[i]) {
					isOk = false;
				}
			}
			if (isOk) {
				//System.out.println(a[i]);
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
