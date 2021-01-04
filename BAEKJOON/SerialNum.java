package BAEKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SerialNum {
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
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else {
					
					String temp1 = o1.replaceAll("[^123456789]", "");
					String temp2 = o2.replaceAll("[^123456789]", "");
					int sum1 = 0;
					int sum2 = 0;
					for (int i = 0; i < temp1.length(); i++) {
						sum1 += Integer.parseInt(temp1.charAt(i) + "");
					}
					for (int i = 0; i < temp2.length(); i++) {
						sum2 += Integer.parseInt(temp2.charAt(i) + "");
					}
					if(sum1 != sum2) {
						return sum1 - sum2;
					}else {
						return o1.compareTo(o2);
					}
				}
			}

		});

		for (String s : wordArr) {
			System.out.println(s);
		}
	}
}
