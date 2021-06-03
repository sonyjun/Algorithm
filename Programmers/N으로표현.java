package Programmers;

import java.util.HashSet;
import java.util.Iterator;

public class N으로표현 {
	public static void main(String[] args) {
		System.out.println(solution(5, 5));
//		System.out.println(solution(2, 11));
//		System.out.println(solution(2, 1));
//		System.out.println(solution(1, 32000));
	}

	public static int solution(int N, int number) {
		// N을 1~8번 썻을 때 얻을 수 있는 수를 보관 할 용도,
		HashSet<Integer>[] hsArr = new HashSet[9];

		int temp = 0;
		for (int i = 1; i < hsArr.length; i++) {
			hsArr[i] = new HashSet<Integer>();
			temp = temp * 10 + N;
			hsArr[i].add(temp);
		}
		if(N == number) {
			return 1;
		}
		hsArr[1].add(N);
		for (int i = 2; i < hsArr.length; i++) {
			for (int j = i / 2; j < i; j++) {
				Iterator<Integer> iter1 = hsArr[j].iterator();// 하나의 집합.
				while (iter1.hasNext()) {
					int iter1Num = iter1.next();
					// 두 집합의 모든 사칙연산을 i 집합에 넣어줌.
					Iterator<Integer> iter2 = hsArr[i - j].iterator();// 또 하나의 집합.
					while (iter2.hasNext()) {
						int iter2Num = iter2.next();
						hsArr[i].add(iter1Num + iter2Num);
						hsArr[i].add(iter1Num - iter2Num);
						hsArr[i].add(iter1Num * iter2Num);
						if (iter2Num != 0) {
							hsArr[i].add(iter1Num / iter2Num);
						}
						hsArr[i].add(iter2Num + iter1Num);
						hsArr[i].add(iter2Num - iter1Num);
						hsArr[i].add(iter2Num * iter1Num);
						if (iter1Num != 0) {
							hsArr[i].add(iter2Num / iter1Num);
						}
					}
				}
			}
			if (hsArr[i].contains(number)) {
				return i;
			}
			// System.out.println(hsArr[i]);
		}
		return -1;
	}

}
