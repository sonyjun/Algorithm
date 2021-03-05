package Programmers;

import java.util.HashMap;
import java.util.Iterator;

public class SPY {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } }));
		System.out.println(solution(
				new String[][] { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } }));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
		}
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			answer *= hm.get(iter.next()) + 1;
		}
		return answer - 1;
	}
}
