package Programmers;

import java.util.Arrays;

public class Level3_1_1 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 4, 2 }, new int[] { 5, 4, 4 }));
		System.out.println(solution(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[A.length -1 - i];
		}
		return sum;
	}
}
