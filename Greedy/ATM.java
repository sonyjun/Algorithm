package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] timeArr = new int[num];
		for (int i = 0; i < timeArr.length; i++) {
			timeArr[i] = input.nextInt();
		}
		Arrays.sort(timeArr);
		int time = timeArr[0];
		for (int i = 1; i < timeArr.length; i++) {
			timeArr[i] += timeArr[i - 1];
			time += timeArr[i];
		}
		System.out.println(time);
	}
}
