package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MenuRenewer {
	static HashMap<String, Integer> hm;
	static int MaxNum = Integer.MIN_VALUE;

	public static void main(String[] args) {

		String[] answer1 = solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
				new int[] { 2, 3, 4 });
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		String[] answer2 = solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" },
				new int[] { 2, 3, 5 });
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		String[] answer3 = solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 });
	}

	public static String[] solution(String[] orders, int[] course) {
		int maxArrIdx = 0;
		hm = new HashMap<String, Integer>();
		int[] maxArr = new int[course.length];
		for (int i = 0; i < orders.length; i++) {
			String[] temp = new String[orders[i].length()];
			for(int j = 0 ; j < temp.length ; j++) {
				temp[j] = orders[i].charAt(j)+"";
			}
			Arrays.sort(temp);
			orders[i] = "";
			for(int j = 0 ; j < temp.length ; j++) {
				orders[i] += temp[j];
			}
		}
		
		
		for (int i = 0; i < course.length; i++) {
			MaxNum = Integer.MIN_VALUE;
			for (int j = 0; j < orders.length; j++) {
				int[] comArr = new int[course[i]];
				combination(orders[j], comArr, orders[j].length(), course[i], 0, 0);
			}
			maxArr[maxArrIdx++] = MaxNum;
		}
		
		
		ArrayList<String> answerList = new ArrayList<String>();
		for (int i = 0; i < course.length; i++) {
			Iterator<String> iter = hm.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				if (maxArr[i] != Integer.MIN_VALUE && maxArr[i] != 1)
					if (key.length() == course[i] && hm.get(key) == maxArr[i]) {
						answerList.add(key);
					}
			}
		}
		
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	private static void combination(String s, int[] comArr, int n, int r, int index, int target) {
		if (r == 0) {
			String str = "";
			for (int i : comArr) {
				str += (char) i;
			}
			hm.put(str, hm.getOrDefault(str, 0) + 1);
			MaxNum = Math.max(MaxNum, hm.getOrDefault(str, 0));
			return;
		}
		if (target == n)//
			return;

		comArr[index] = s.charAt(target);
		combination(s, comArr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(s, comArr, n, r, index, target + 1);// 안뽑는경우

	}
}
