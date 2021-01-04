package Hash;

import java.util.HashMap;

public class Spy {
	public static void main(String args[]) {
		SolutionSpy s = new SolutionSpy();
		String[][] clothes1 = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		String[][] clothes2 = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		s.solution(clothes1);
		s.solution(clothes2);
	}
}

class SolutionSpy {
	public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
		}
		for (String s : hm.keySet()) {
			answer *= hm.get(s) + 1;
		}
		return answer-1;
	}
}
