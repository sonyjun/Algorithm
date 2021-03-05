package Programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Level2_2_1 {
	public static void main(String[] args) {
		String str11 = "FRANCE";
		String str12 = "french";

		String str21 = "handshake";
		String str22 = "shake hands";

		String str31 = "aa1+aa2";
		String str32 = "AAAA12";

		String str41 = "E=M*C^2";
		String str42 = "e=m*c*c^2";

		System.out.println(solution(str11, str12));
		System.out.println(solution(str21, str22));
		System.out.println(solution(str31, str32));
		System.out.println(solution(str41, str42));
	}

	public static int solution(String str1, String str2) {
		String upperStr1 = str1.toUpperCase();
		String upperStr2 = str2.toUpperCase();

		HashMap<String, Integer> firstStrMap = new HashMap<>();
		HashMap<String, Integer> secondStrMap = new HashMap<>();
		String regExp = "^[A-Z]+$";// temp.matches(regExp)
		for (int i = 0; i < upperStr1.length() - 1; i++) {
			String temp = upperStr1.substring(i, i + 2);
			if (temp.matches(regExp)) {
				firstStrMap.put(temp, firstStrMap.getOrDefault(temp, 0) + 1);
			}
		}
		for (int i = 0; i < upperStr2.length() - 1; i++) {
			/// secondStr[i] = upperStr2.substring(i, i + 2);
			String temp = upperStr2.substring(i, i + 2);
			if (temp.matches(regExp)) {
				secondStrMap.put(temp, secondStrMap.getOrDefault(temp, 0) + 1);
			}
		}

		double gyo = 0; //교집합 개수
		double hap = 0; //교집합 개수
		Iterator<String> iter =firstStrMap.keySet().iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			if(secondStrMap.containsKey(temp)) {
				int minNum = Math.min(firstStrMap.get(temp), secondStrMap.get(temp));
				int maxNum = Math.max(firstStrMap.get(temp), secondStrMap.get(temp));
				gyo += minNum;
				hap += maxNum;
				secondStrMap.replace(temp, 0);
				firstStrMap.replace(temp, 0);
			}else {
				hap += firstStrMap.get(temp);
				secondStrMap.replace(temp, 0);
			}
		}
		
		iter = secondStrMap.keySet().iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			hap += secondStrMap.get(temp);
		}
		//System.out.println(gyo/hap);
		if(hap == 0) {
			return 65536;
		}else {
			return (int)((gyo/hap) * 65536);
		}
	}
}
