package Greedy;

import java.util.Scanner;

public class Coin {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] won = new int[num];
		int k = input.nextInt();
		for (int i = 0; i < won.length; i++) {
			won[i] = input.nextInt();
		}

		int index = won.length - 1;
		int count = 0;
		while (k != 0) {
			if(won[index] <= k) {
				k -= won[index];
				count++;
			}else {
				index--;
			}
		}
		System.out.println(count);

	}
}
