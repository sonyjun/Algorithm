package Programmers;

import java.util.ArrayList;

public class FunctionDevelopment {
	public static void main(String[] args) {
		int[] answer1 = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
		System.out.println("+=============================");
		solution(new int[] { 99, 99, 99 }, new int[] { 1, 1, 1 });
		System.out.println("+=============================");
		int[] answer2 = solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] dayArr = new int[progresses.length];
		for (int i = 0; i < dayArr.length; i++) {
			dayArr[i] = (100 - progresses[i]) / speeds[i];
			if (!((100 - progresses[i]) % speeds[i] == 0)) {
				dayArr[i]++;
			}
		}
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		int current = 0;// 현재 탐색중인 기능이걸리는 날짜.
		int count;// 끊어질 때 마다 몇개나 베포 되는지
		for (int i = 0; i < dayArr.length; i++) {
			current = dayArr[i];
			count = 1;
			if (dayArr[i] != 0) {
				dayArr[i] = 0;
				for (int j = i + 1; j < dayArr.length; j++) {// 자신보다 늦게 베포될 녀석을 만나면 멈춤.
					if (current >= dayArr[j]) {// 다음에 올 녀석이 현재 베포될 녀석 보다 덜 걸린다면, 같이 베포 가능.
						count++;
						dayArr[j] = 0;// 배포되었으면 0으로 표시.
					} else {
						i = j - 1;
						break;
					}
				}
				System.out.println(count);
				answerList.add(count);
			}

		}

		int[] answer = new int[answerList.size()];
		int index = 0;
		for (int i : answerList) {
			answer[index++] = i;
		}
		return answer;
	}
}
