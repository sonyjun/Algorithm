package PracticeCoding;

import java.util.HashMap;

public class Algorithm18 {
	public static void main(String args[]) {
		Solution18 s18 = new Solution18();
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(s18.solution(participant, completion));
		String[] participant1 = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion1 = { "josipa", "filipa", "marina", "nikola" };
		System.out.println(s18.solution(participant1, completion1));
		String[] participant2 = { "mislav", "stanko", "mislav", "ana" };
		String[] completion2 = { "stanko", "ana", "mislav" };
		System.out.println(s18.solution(participant2, completion2));
	}
}

class Solution18 {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i < participant.length; i++) {
			hm.put(participant[i], hm.getOrDefault(participant[i], 0) + 1);
		}

		for (int i = 0; i < completion.length; i++) {
			if(hm.get(completion[i]) > 1) {
				hm.replace(completion[i], hm.get(completion[i])-1);
			}else {
				hm.remove(completion[i]);
			}
		}
		
		String answer = hm.keySet().iterator().next();
		return answer;
	}
}