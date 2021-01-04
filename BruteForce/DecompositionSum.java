package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DecompositionSum {
	static int targetNum = 0;
	static int minNum = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		targetNum = Integer.parseInt(n);
		int len = n.length();
		LinkedList<Integer> rePerArr = new LinkedList<Integer>();
		rePermutation(10, len, rePerArr);
		if(minNum == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(minNum);
		}
	}

	private static void rePermutation(int n, int r, LinkedList<Integer> rePerArr) {
		if (rePerArr.size() == r) {
			int sum = 0;// 해당 자리수에 맞도록 뽑아서 나온 값들의 각 자리수의 합.
			String strTemp = "";// 해당 자리수에 맞도록 뽑아서 나온 값들의 각 자리수를 그냥 문자열로 합친 값.
			int intTemp = 0;
			for (int i : rePerArr) {
				//System.out.print(i + " ");
				strTemp += i;
				sum += i;
			}
			intTemp = Integer.parseInt(strTemp);
			if (intTemp + sum == targetNum) {//
				if(intTemp < minNum) {
					minNum = intTemp;
				}
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			rePerArr.add(i);
			rePermutation(n, r, rePerArr);
			rePerArr.removeLast();

		}

	}
}
