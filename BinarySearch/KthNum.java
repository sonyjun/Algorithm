package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KthNum {// 백준 K번째 수. 1300번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		long answer = 0;
		long left = 1;
		long right = k;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}
			if (count < k) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
