package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class MaxNum {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 0, 0, 0, 34, 5, 9 }));
		System.out.println(solution(new int[] { 0, 0, 0, 0, 0, 0 }));
	}

	public static String solution(int[] numbers) {
		Num[] changedNum = new Num[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			String temp = "";
			while (temp.length() <= 3) {
				temp += numbers[i];
			}
			temp = temp.substring(0, 4);
			changedNum[i] = new Num(numbers[i], Integer.parseInt(temp));
		}
		Arrays.sort(changedNum);
		String answer = "";
		for (int i = 0; i < changedNum.length; i++) {
			answer += changedNum[i].origin;
		}
		if (!answer.startsWith("0")) {
			return answer;
		} else {
			return "0";
		}
	}
}

class Num implements Comparable<Num> {
	int origin;
	int changed;

	public Num(int origin, int changed) {
		this.origin = origin;
		this.changed = changed;
	}

	@Override
	public int compareTo(Num o) {
		// TODO Auto-generated method stub
		return o.changed - this.changed;
	}
}
