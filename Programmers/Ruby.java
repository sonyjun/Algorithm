package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ruby {
	public static void main(String[] args) {
		int[] answer1 = solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" });
		int[] answer2 = solution(new String[] { "AA", "AB", "AC", "AA", "AC" });
		// int[] answer3 = solution(new String[] { "XYZ", "XYZ", "XYZ" });
		int[] answer4 = solution(new String[] { "DIA", "EM", "EM", "RUB", "DIA" });
		// System.out.println(answer4[0] + ", " + answer4[1]);
	}

	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int count = 0;
		HashSet<String> hm = new HashSet<String>();
		for (int i = 0; i < gems.length; i++) {
			hm.add(gems[i]);
		}
		count = hm.size();
		if (count == 1) {
			return new int[] { 1, 1 };
		}
		int left = 0;
		int right = left + 1;
		HashSet<String> originHm = new HashSet<String>();
		HashSet<String> compareHm = new HashSet<String>();
		ArrayList<Range> answerList = new ArrayList<Range>();
		originHm.add(gems[left]);
		for (int i = left + 1; i < gems.length; i++) {// 배열을 하나씩 비교해나갈거임.
			if (!originHm.contains(gems[i])) {// 포함 안하고 있는 녀석이면 넣어줌.
				originHm.add(gems[i]);
				compareHm.add(gems[i]);
				right = i;
			} else {// 이미 포함하고 있는 녀석이면 left가 옮겨져야 할지 따짐.
				compareHm.add(gems[i]);
				if (originHm.size() == compareHm.size()) {
					compareHm = new HashSet<String>();
					// 새롭게 들어온 녀석이 이미 있는 녀석이라는 뜻.

					// left랑 right 옮겨줘야댐.
					right = i;
					int index = 0;
					for (int j = left + 1; j < right; j++) {
						if (gems[left + 1] == gems[j]) {
							index = j;
						}
					}
					left = index;
					for (int j = left + 1; j <= right; j++) {
						compareHm.add(gems[j]);
					}
					System.out.println(compareHm);
				}
			}
			if (originHm.size() == count) {
				answerList.add(new Range(right - left, left + 1, right + 1));
				// break;
			}
		}
		Collections.sort(answerList);
		answer[0] = answerList.get(0).left;
		answer[1] = answerList.get(0).right;
		return answer;
	}
}

class Range implements Comparable<Range> {
	int range;
	int left;
	int right;

	public Range(int range, int left, int right) {
		this.range = range;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Range o) {
		// TODO Auto-generated method stub
		if (this.range - o.range > 0) {
			return 1;
		} else if (this.range - o.range < 0) {
			return -1;
		} else {
			return this.left - o.left;
		}
	}
}
