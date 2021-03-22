package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CandidateKey {
	static String[][] staticRelation;
	static int count = 0;
	static HashSet<String> hs;

	public static void main(String[] args) {
		solution(new String[][] { { "100", "ryan", "music", "1" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "5" },
				{ "600", "apeach", "music", "6" } });
		solution(new String[][] { { "a", "aa" }, { "aa", "a" }, { "a", "a" } });
		String[][] args2 = new String[][] { { "4", "4", "사랑", "2020-07-03 오전 12:00:00", "love" },
				{ "5", "4", "같은, 좋은, 와 비슷한", "2020-07-03 오전 12:00:00", "like" },
				{ "6", "4", "사과,대도시", "2020-07-03 오전 12:00:00", "apple" },
				{ "7", "4", "빌다,기도하다,에게 간청하다", "2020-07-03 오전 12:00:00", "pray" },
				{ "8", "4", "빌다,기도하다,에게 간청하다", "2020-06-27 오전 12:00:00", "pray" },
				{ "9", "4", "안녕", "2020-07-03 오전 12:00:00", "hi" },
				{ "10", "3", "같은, 좋은", "2020-06-29 오전 12:00:00", "like" },
				{ "11", "2", "나는 모자를 벗는다", "2020-06-27 오전 12:00:00", "I take off my hat" } };
		solution(args2);
		String[][] args1 = new String[][] { { "4", "4", "사랑", "2020-07-03 오전 12:00:00", "love" },
				{ "5", "4", "같은, 좋은, 와 비슷한", "2020-07-03 오전 12:00:00", "like" },
				{ "6", "4", "사과,대도시", "2020-07-03 오전 12:00:00", "apple" },
				{ "7", "4", "빌다,기도하다,에게 간청하다", "2020-07-03 오전 12:00:00", "pray" },
				{ "8", "3", "빌다,기도하다,에게 간청하다", "2020-06-27 오전 12:00:00", "pray" },
				{ "9", "4", "안녕", "2020-07-03 오전 12:00:00", "hi" },
				{ "10", "3", "같은, 좋은", "2020-06-29 오전 12:00:00", "like" },
				{ "11", "2", "나는 모자를 벗는다", "2020-06-27 오전 12:00:00", "I take off my hat" } };
		solution(args1);

		/*
		 * solution(new String[][] { { "100", "ryan", "music", "2"}, { "200", "apeach",
		 * "math", "2" }, { "300", "tube", "computer", "3" }, { "400", "con",
		 * "computer", "4" }, { "500", "muzi", "music", "3" }, { "600", "apeach",
		 * "music", "2" } });
		 */
	}

	public static int solution(String[][] relation) {
		hs = new HashSet<String>();
		staticRelation = relation;
		for (int i = 1; i <= relation[0].length; i++) {
			int[] comArr = new int[i];
			combination(comArr, relation[0].length, i, 0, 0);
		}
		//System.out.println(hs);
		return count;
	}

	private static void combination(int[] comArr, int n, int r, int index, int target) {
		if (r == 0) {
			// 원하는 갯수를 다 뽑았을 경우.
			String answerCom = "";
			for (int i : comArr) {
				answerCom += i;
			}

			//유일성을 만족하는가 1.HashMap을 이용해 갯수 파악해줌
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			for (int i = 0; i < staticRelation.length; i++) {
				String currentStr = "";
				for (int j = 0; j < comArr.length; j++) {
					currentStr += staticRelation[i][comArr[j]] + ' ';
				}
				// System.out.println(currentStr);
				hm.put(currentStr, hm.getOrDefault(currentStr, 0) + 1);
			}

			//유일성을 만족하는가 2.HashMap을 이용해 2개 이상이면 불가
			Iterator<String> iter = hm.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				if (hm.get(key) > 1) {
					// System.out.println("중복 값 있습니다.");
					return;
				}
			}

			//최소성을 만족하는가
			iter = hs.iterator();
			boolean isOk = true;
			while (iter.hasNext()) {
				String key = iter.next();
				int count = 0;
				for (int i = 0; i < key.length(); i++) {//기존 후보키의 문자 하나하나씩
					if(answerCom.contains(key.charAt(i)+"")) {
						count++;
					}
				}
				if(key.length() == count) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				count++;
				hs.add(answerCom);
			}
			return;
		}
		if (target == n)
			return;

		comArr[index] = target;
		combination(comArr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(comArr, n, r, index, target + 1);// 안뽑는경우

	}
}
