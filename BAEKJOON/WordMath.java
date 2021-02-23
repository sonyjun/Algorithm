package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class WordMath {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// String[] inputStr = new String[N];
		LinkedList<Alphabet>[] positionValue = new LinkedList[9];// 최대 8자리 숫자이므로.
		int[] alphabetCount = new int[27];
		String[] inputStrArr = new String[N];
		for (int i = 1; i < positionValue.length; i++) {
			positionValue[i] = new LinkedList<>();
		}
		for (int i = 0; i < N; i++) {
			// inputStr[i] = br.readLine();
			String inputStr = br.readLine();
			inputStrArr[i] = inputStr;
			int strLength = inputStr.length();
			for (int j = 0; j < inputStr.length(); j++) {
				positionValue[strLength - j].add(new Alphabet(inputStr.charAt(j), alphabetCount));
				alphabetCount[inputStr.charAt(j) - 64]++;
			}
		}
		for (int i = 1; i < positionValue.length; i++) {
			Collections.sort(positionValue[i]);
		}
		HashMap<String, Integer> hm = new HashMap<>();

		int num = 9;
		int maxSum = 0;
		for (int i = positionValue.length - 1; i > 0; i--) {

			for (Alphabet a : positionValue[i]) {//i가 자릿수를 나타냄.
				if (!hm.containsKey(a.s+"")) {
					hm.put(a.s+"", num);
					maxSum += num * Math.pow(10,i-1);
					num--;
				}else {
					maxSum += hm.get(a.s+"") * Math.pow(10,i-1);
				}
			}

		}
		System.out.println(maxSum);
	}
}

class Alphabet implements Comparable<Alphabet> {
	char s;
	int[] alphabetCount;

	public Alphabet(char s, int[] alphabetCount) {
		this.s = s;
		this.alphabetCount = alphabetCount;
	}

	@Override
	public int compareTo(Alphabet o) {
		// TODO Auto-generated method stub
		return alphabetCount[o.s - 64] - alphabetCount[s - 64];
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

 * */
