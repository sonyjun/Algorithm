package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class WordMath2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alphabetToNumArr = new int[27];
		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < inputStr.length(); j++) {
				alphabetToNumArr[inputStr.charAt(j) - 64] += Math.pow(10, inputStr.length() - j - 1);
			}
		}
		Arrays.sort(alphabetToNumArr);
		int sum = 0;
		int num = 9;
		for (int i = alphabetToNumArr.length - 1; i >= 1; i--) {
			sum += alphabetToNumArr[i] * num--;
		}
		System.out.println(sum);
		/*for (int i = 1; i < alphabetToNumArr.length; i++) {
			System.out.print(alphabetToNumArr[i] + " ");
		}
		System.out.println();*/
	}
}
/*
14
ABB
BB
BB
BB
BB
BB
BB
BB
BB
BB
BB
BB
BB
BB
 * 
 */
