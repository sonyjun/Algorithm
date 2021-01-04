package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class BigNum {
	public static void main(String args[]) {
		BigNumSolution b = new BigNumSolution();
		int[] numbers1 = { 6, 10, 2 };
		int[] numbers2 = { 0, 0, 0, 0 };
		System.out.println(b.solution(numbers1));
		System.out.println(b.solution(numbers2));
	}
}

class BigNumSolution {
	public String solution(int[] numbers) {
		String answer = "";
		String[] numStr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numStr[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(numStr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}

		});
		if (numStr[0].startsWith("0")) {
			answer = "0";
		} else {
			for (int i = 0; i < numStr.length; i++) {
				answer += numStr[i];
			}
		}
		return answer;
	}
}
