package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriQue {
	public static void main(String arg[]) {
		DoublePriQueSolution d = new DoublePriQueSolution();
		String[] operations1 = { "I 16", "D 1" };
		String[] operations2 = { "I 7", "I 5", "I -5", "D -1" };
		String[] operations3 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		String[] operations4 = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		d.solution(operations1);
		d.solution(operations2);
		d.solution(operations3);
		d.solution(operations4);
	}
}

class DoublePriQueSolution {
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> minPriQue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPriQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < operations.length; i++) {
			switch (operations[i].charAt(0)) {
			case 'I': {
				int temp = Integer.parseInt(operations[i].substring(2));
				minPriQue.add(temp);
				maxPriQue.add(temp);
				break;
			}
			case 'D': {
				int temp = Integer.parseInt(operations[i].substring(2));
				if (temp < 0) {
					if (!minPriQue.isEmpty()) {
						int deletedEle = minPriQue.poll();
						maxPriQue.remove(deletedEle);
					}
				} else {
					if (!maxPriQue.isEmpty()) {
						int deletedEle = maxPriQue.poll();
						minPriQue.remove(deletedEle);
					}
				}
				break;
			}
			}
		}
		int[] answer = new int[2];
		if (!minPriQue.isEmpty() && !maxPriQue.isEmpty()) {
			answer[0] = maxPriQue.poll();
			answer[1] = minPriQue.poll();
		}

		System.out.println("[" + answer[0] + "," + answer[1] + "]");
		return answer;
	}
}