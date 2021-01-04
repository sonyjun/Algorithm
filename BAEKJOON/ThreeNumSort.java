package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeNumSort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] nums = new int[3];
		int index = 0;
		nums[index++] = input.nextInt();
		nums[index++] = input.nextInt();
		nums[index++] = input.nextInt();
		Arrays.sort(nums);
		for(int i : nums) {
			System.out.print(i+" ");
		}
	}
}