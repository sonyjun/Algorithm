package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutLanCable {// 백준 랜선 자르기. 1654번
	static int[] lanCableArr;
	static long totalMaxLength = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		lanCableArr = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			lanCableArr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lanCableArr[i]);
		}
		upperBound(max, n);
		System.out.println(totalMaxLength);
	}

	private static long upperBound(long maxLength, long target) {
		long begin = 1;
		long end = maxLength;

		while (begin <= end) {
			long mid = (begin + end) / 2;
			System.out.println("start: " + begin + " , mid : " + mid + " , end :" + end);
			System.out.println("mid의 계산값 : " + CalcLanCableNum(mid));
			if (CalcLanCableNum(mid) >= target) {
				System.out.println("1번");
				begin = mid + 1;
				if (totalMaxLength < mid) {
					totalMaxLength = mid;
				}
			} else {
				System.out.println("2번");
				end = mid - 1;
			}
		}
		return end;
	}

	private static long CalcLanCableNum(long length) {
		int count = 0;
		for (int i = 0; i < lanCableArr.length; i++) {
			count += lanCableArr[i] / length;
		}
		return count;
	}
}
