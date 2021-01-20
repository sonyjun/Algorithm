package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum {// 백준 수 찾기. 10816번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numSize = Integer.parseInt(br.readLine());
		int[] numArr = new int[numSize];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numSize; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		int findN = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < findN; i++) {
			sb.append(binarySearch(numArr, Integer.parseInt(st.nextToken()))+"\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int[] A, int n) {
		int first = 0;
		int last = A.length - 1;
		int mid = 0;

		while (first <= last) {
			mid = (first + last) / 2;

			if (n == A[mid])
				return 1;
			else {
				if (n < A[mid])
					last = mid - 1;
				else
					first = mid + 1;
			}
		}
		return 0;
	}
}
