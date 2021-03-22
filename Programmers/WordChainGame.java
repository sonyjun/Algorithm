package Programmers;

import java.util.HashSet;

public class WordChainGame {
	public static void main(String[] args) {
		solution(3, new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });
		solution(5, new String[] { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive" });
		solution(2, new String[] { "hello", "one", "even", "never", "now", "world", "draw" });
	}

	public static int[] solution(int n, String[] words) {
		int who = 0;
		int[] howManyCount = new int[n];
		HashSet<String> hs = new HashSet<String>();
		int[] answer = new int[2];
		String prevWord = words[0].charAt(0)+"";
		for (int i = 0; i < words.length; i++) {// 몇번째 단어인지.
			howManyCount[who]++;
			String currentWord = words[i];
			//System.out.println("이전단어  : "+prevWord);
			//System.out.println("현재단어  : "+currentWord);
			if (hs.contains(currentWord) || !prevWord.endsWith(currentWord.charAt(0) + "")) {// 이미 있는 단어 말하는 경우. 탈락
				answer[0] = (who + 1);
				answer[1] = howManyCount[who];
				return answer;
			}
			prevWord = currentWord;
			hs.add(currentWord);
			who = (who + 1) % n;
		}
		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}
}
