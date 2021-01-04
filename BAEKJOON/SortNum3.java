package BAEKJOON;

import java.util.Scanner;

public class SortNum3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//
		int[] numCountArr = new int[10001];//
		for (int i = 0; i < n; i++) {
			numCountArr[input.nextInt()]++;
		}
		for (int i = 1; i < 10001 ; i++) {
			while(numCountArr[i] > 0) {
				System.out.println(i);
				numCountArr[i]--;
			}
		}
	}
}
