package Programmers;

import java.util.HashMap;
import java.util.Iterator;

public class UnfinishedAthlete {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "marina", "josipa", "nikola", "vinko", "filipa" },
				new String[] { "josipa", "filipa", "marina", "nikola" }));
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++) {
			hm.put(participant[i], hm.getOrDefault(participant[i], 0) + 1);
		}
		for (int i = 0; i < completion.length; i++) {
			int num = hm.get(completion[i]);
			if (num != 1) {
				hm.replace(completion[i], hm.get(completion[i]) - 1);
			} else {
				hm.remove(completion[i]);
			}
		}
		Iterator<String> iter = hm.keySet().iterator();
		return iter.next();
	}
}
