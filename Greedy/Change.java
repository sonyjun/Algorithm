package Greedy;

import java.util.Scanner;

public class Change {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int price = input.nextInt();
		int change = 1000 - price;
		int[] en = new int[] { 500, 100, 50, 10, 5, 1 };
		int index = 0;
		int count = 0;
		while (change > 0) {
			if (change >= en[index]) {
				// System.out.println(change);
				change -= en[index];
				count++;
			} else {
				index++;
			}
		}
		System.out.println(count);
	}
}
