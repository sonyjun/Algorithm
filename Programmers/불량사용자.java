package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 불량사용자 {
	public static void main(String[] args) {
		Solution불량사용자 s = new Solution불량사용자();
		s.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" }, new String[] { "fr*d*", "abc1**" });
		s.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "*rodo", "*rodo", "******" });
		s.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "fr*d*", "*rodo", "******", "******" });

	}
}

class Solution불량사용자 {
	String[] User_id;
	String[] Banned_id;
	String[] regexArr;
	String[] answerArr;
	ArrayList<String> answerList;
	boolean[] visited;

	public int solution(String[] user_id, String[] banned_id) {
		regexArr = new String[banned_id.length];
		answerArr = new String[banned_id.length];// 정답이 될 수 있는 수를 담을 배열, 한가지 경우의 수를 담을 배열
		answerList = new ArrayList<String>();// 정답이 될 수 있는 모든 경우의 수를 담는 배열
		for (int i = 0; i < banned_id.length; i++) {
			String regex = banned_id[i].replaceAll("\\*", ".");// 정규표현식으로 바꾸어 관리함.
			regexArr[i] = regex;
		}
		visited = new boolean[user_id.length];// 브루트포스를 위한 방문 배열
		User_id = user_id;
		Banned_id = banned_id;
		go(0);
		Collections.sort(answerList);// 정답리스트에 담긴 배열에 중복을 쉽게 처리하기 위해 정렬.O(logN)
		for (int i = 0; i < answerList.size(); i++) {// 중복된 값 하나씩 빼주면 됨. O(N)으로 가능.
			for (int j = i + 1; j < answerList.size(); j++) {
				if (answerList.get(i).equals(answerList.get(j))) {
					answerList.remove(j);
					j--;
				} else {
					break;
				}
			}
		}
		System.out.println(answerList.size());
		return answerList.size();
	}

	public void go(int position) {
		if (position == Banned_id.length) {// 원하는 길이만큼 다 구했으면 종료.
			StringBuilder sb = new StringBuilder();
			String[] temp = answerArr.clone();
			Arrays.sort(temp);// 중복의 발생이 있기 때문에, 정렬을 하고 정답 리스트에 넣음.
			for (int i = 0; i < temp.length; i++) {
				sb.append(temp[i]);
			}
			answerList.add(sb.toString());
			return;
		}
		for (int i = 0; i < User_id.length; i++) {// 정규표현식에 맞다면 세팅하고, 다음 호출
			if (visited[i] == false) {
				if (User_id[i].matches(regexArr[position])) {
					visited[i] = true;
					answerArr[position] = User_id[i];
					go(position + 1);
					visited[i] = false;
				}
			}
		}
	}
}