package Greedy;

import java.util.ArrayList;
import java.util.List;

public class MakeBigNum {
	public static void main(String args[]) {
		MakeBigNumSolution m = new MakeBigNumSolution();
		String number1 = "1924";
		int k1 = 2;
		String number2 = "1231234";
		int k2 = 3;
		String number3 = "9999";
		int k3 = 3;
		System.out.println(m.solution(number1, k1));
		System.out.println(m.solution(number2, k2));
		System.out.println(m.solution(number3, k3));
	}
}

class MakeBigNumSolution {
	public String solution(String number, int k) {
		StringBuilder a = new StringBuilder(number);
		int i = 0;
		int j = 0;
		int idx;
		int l;

		for (i = 0; i < k; i++) {//k번만큼 반복. k개를 삭제하기 위해.
			l = a.length();
			idx = l - 1;
			for (j = 0; j < l - 1; j++) {//삭제할 녀석을 찾는 반복문.
				if (a.charAt(j) < a.charAt(j + 1)) {//다음인덱스가 더 큰 놈이 있다면 멈춤.
					idx = j;//삭제해야될 녀석을 idx에 저장.
					break;
				}
			}//큰놈이 없다면.. 제일 마지막놈 삭제.

			a.deleteCharAt(idx);//삭제
		}

		return a.toString();
	}
}
