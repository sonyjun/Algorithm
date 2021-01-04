package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class NormalSort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numCount = input.nextInt();
		int[] nums = new int[numCount];
		for (int i = 0; i < numCount; i++) {
			nums[i] = input.nextInt();
		}
		Arrays.sort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
