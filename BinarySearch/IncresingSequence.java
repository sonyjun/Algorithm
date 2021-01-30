package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncresingSequence {// 백준 가장 긴 증가하는 부분 수열 2. 12015번

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		int[] answer = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		int index = 0;// 제일 마지막 인덱스를 가리킴.(값이 있어야함)
		answer[0] = numArr[0];
		for (int i = 1; i < numArr.length; i++) {
			if (answer[index] < numArr[i]) {
				answer[++index] = numArr[i];
			} else {
				answer[lowerBound(answer, index + 1, numArr[i])] = numArr[i];
			}
		}
	}

	private static int lowerBound(int[] data, int size, int target) {
		int begin = 0;
		int end = size;

		while (begin < end) {
			int mid = (begin + end) / 2;

			if (data[mid] >= target) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return end;
	}
}