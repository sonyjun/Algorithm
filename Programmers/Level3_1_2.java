package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Level3_1_2 {
	static boolean[] visited;
	static int finishCount;
	static ArrayList<String> answerList;
	static String[][] ticket;

	public static void main(String[] args) {
		String[] answer1 = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		String[] answer2 = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
				{ "ATL", "ICN" }, { "ATL", "SFO" } });
		for (String s : answer1) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : answer2) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	public static String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		ticket = tickets;
		finishCount = tickets.length;
		answerList = new ArrayList<String>();
		DFS("ICN", 0, "ICN");
		Collections.sort(answerList);
		String[] answer = answerList.get(0).split(" ");
		return answer;
	}

	public static void DFS(String target, int count, String answer) {
		// System.out.println(target);
		// System.out.println(count);
		if (count == finishCount) {
			//System.out.println("answer목록 중 하나 : " + answer);
			answerList.add(answer);
		}
		for (int i = 0; i < ticket.length; i++) {
			if (visited[i] == false && ticket[i][0].equals(target)) {
				visited[i] = true;
				DFS(ticket[i][1], count + 1, answer + " " + ticket[i][1]);
				visited[i] = false;
			}
		}
	}
}
