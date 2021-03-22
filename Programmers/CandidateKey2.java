package Programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class CandidateKey2 {
	static ArrayList<HashSet<Integer>> candidateKey;
	static String Table[][];
	static int length;
	static int answer;

	public static void main(String[] args) {
		/*
		 * solution(new String[][] { { "100", "ryan", "music", "1" }, { "200", "apeach",
		 * "math", "2" }, { "300", "tube", "computer", "3" }, { "400", "con",
		 * "computer", "4" }, { "500", "muzi", "music", "5" }, { "600", "apeach",
		 * "music", "6" } }); String[][] args2 = new String[][] { { "4", "4", "사랑",
		 * "2020-07-03 오전 12:00:00", "love" }, { "5", "4", "같은, 좋은, 와 비슷한",
		 * "2020-07-03 오전 12:00:00", "like" }, { "6", "4", "사과,대도시",
		 * "2020-07-03 오전 12:00:00", "apple" }, { "7", "4", "빌다,기도하다,에게 간청하다",
		 * "2020-07-03 오전 12:00:00", "pray" }, { "8", "4", "빌다,기도하다,에게 간청하다",
		 * "2020-06-27 오전 12:00:00", "pray" }, { "9", "4", "안녕",
		 * "2020-07-03 오전 12:00:00", "hi" }, { "10", "3", "같은, 좋은",
		 * "2020-06-29 오전 12:00:00", "like" }, { "11", "2", "나는 모자를 벗는다",
		 * "2020-06-27 오전 12:00:00", "I take off my hat" } }; solution(args2);
		 */
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
		answer = 0;
		candidateKey = new ArrayList<HashSet<Integer>>();
		Table = relation;
		length = relation[0].length;
		for (int i = 1; i <= length; i++) {
			makeSet(-1, i, 0, new HashSet<Integer>());
		}

		return answer;
	}

	public static void makeSet(int index, int target, int count, HashSet<Integer> set) {

		if (count == target) {
			if (!isUnique(set)) {
				return;
			}
			for (HashSet<Integer> key : candidateKey) {
				if (set.containsAll(key)) {
					return;
				}
			}
			System.out.println(set);
			candidateKey.add(set);
			answer++;
			return;
		}

		for (int i = index + 1; i < length; i++) {
			HashSet<Integer> newSet = new HashSet<Integer>(set);
			newSet.add(i);
			makeSet(i, target, count + 1, newSet);
		}

	}

	public static boolean isUnique(HashSet<Integer> set) {

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < Table.length; i++) {
			String temp = "";
			for (int index : set) {
				temp += Table[i][index];
			}
			if (!list.contains(temp)) {
				list.add(temp);
			} else {
				return false;
			}
		}
		return true;
	}
}
