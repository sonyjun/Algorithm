package BAEKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wordSort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] wordArr = new String[n];
		for (int i = 0; i < n; i++) {
			wordArr[i] = input.next();
		}
		Arrays.sort(wordArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}

			}

		});
		String prev = "";
		for (int i = 0; i < wordArr.length; i++) {
			if (!prev.equals(wordArr[i])) {
				System.out.println(wordArr[i]);
			}
			prev = wordArr[i];
		}
	}
}
