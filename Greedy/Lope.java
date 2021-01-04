package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Lope {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] lopeArr = new int[num];
		for (int i = 0; i < lopeArr.length; i++) {
			lopeArr[i] = input.nextInt();
		}
		Arrays.sort(lopeArr);
		int maxWeight = 0;
		for (int i = lopeArr.length - 1; i >= 0; i--) {
			if (lopeArr[i] * (lopeArr.length - i) > maxWeight) {
				maxWeight = lopeArr[i] * (lopeArr.length - i);
			}
		}
		System.out.println(maxWeight);
		/*
		 * for (int i : lopeArr) { System.out.println(i + " "); }
		 */
	}
}
