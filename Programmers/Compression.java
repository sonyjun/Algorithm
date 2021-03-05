package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Compression {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		System.out.println(solution("abcabcabcabcdededededede"));
	}

	public static int solution(String s) {
		Queue<String> que = new LinkedList<String>();
		StringBuilder sb = null;
		for (int i = 1; i <= s.length(); i++) {
			// int i = 8;
			// 1개부터 s/2만큼 쪼개보면서 탐색할거임.
			sb = new StringBuilder();
			for (int j = 0; j < s.length(); j += i) {
				String currentStr = "";
				if (j + i <= s.length()) {
					currentStr = s.substring(j, j + i);
					que.add(currentStr);
				} else {
					currentStr = s.substring(j);
					que.add(currentStr);
				}
			}
			// System.out.println(que);
			while (!que.isEmpty()) {
				String pollStr = que.poll();
				int count = 1;
				while (!que.isEmpty()) {
					if (!que.isEmpty() && que.peek().equals(pollStr)) {
						que.poll();
						count++;
					} else {
						if (count > 1) {
							sb.append(count + pollStr);
						} else {
							sb.append(pollStr);
						}
						// System.out.println(pollStr + ": " + count);
						break;
					}
				}
				if (que.isEmpty()) {
					// System.out.println(pollStr + ": " + count);
					if (count > 1) {
						sb.append(count + pollStr);
					} else {
						sb.append(pollStr);
					}
				}
			}
			min = Math.min(min, sb.length());
			//System.out.println(sb);
		}
		return min;
	}
}
