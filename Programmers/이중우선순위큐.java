package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public static void main(String[] args) {
		Solution이중우선순위큐 s = new Solution이중우선순위큐();
		s.solution(new String[] { "I 5", "I 5", "D 5" });
		s.solution(new String[] { "D 1", "D -1" });
		s.solution(new String[] { "I 7", "I 5", "I -5", "D -1" });
		s.solution(new String[] { "I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6" });
	}
}

class Solution이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		int numCount = 0;
		PriorityQueue<Integer> maxQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minQue = new PriorityQueue<Integer>();
		for (int i = 0; i < operations.length; i++) {
			String[] command = operations[i].split(" ");
			if (command[0].equals("I")) {
				numCount++;
				maxQue.add(Integer.parseInt(command[1]));
				minQue.add(Integer.parseInt(command[1]));
			} else {
				if (numCount == 0) {
					continue;
				}
				if (Integer.parseInt(command[1]) == 1) {// 최대값 삭제
					maxQue.poll();
					numCount--;
				} else {// 최소값 삭제
					minQue.poll();
					numCount--;
				}
			}
			if (numCount == 0) {
				minQue.clear();
				maxQue.clear();
			}
		}
		if (numCount == 1) {
			int num = maxQue.poll();
			answer[0] = num;
			answer[1] = num;
		} else if (numCount >= 2) {
			answer[0] = maxQue.poll();
			answer[1] = minQue.poll();
		}
		System.out.println(answer[0] + "," + answer[1]);
		return answer;
	}
}