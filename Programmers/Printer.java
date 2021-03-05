package Programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}

	public static int solution(int[] priorities, int location) {
		PriorityQueue<Integer> priorityque = new PriorityQueue<Integer>(Collections.reverseOrder());
		// 우선순위 큐는 중요도 높은거 유지하는 용도.

		// 작업 순위는 que로 유지.
		Queue<Document> jobOrder = new LinkedList<Document>();
		for (int i = 0; i < priorities.length; i++) {
			priorityque.add(priorities[i]);
			if (location != i) {
				jobOrder.add(new Document(priorities[i], false));
				continue;
			}
			jobOrder.add(new Document(priorities[i], true));
		}
		int order = 0;
		while (!jobOrder.isEmpty()) {
			if (jobOrder.peek().priority == priorityque.peek()) {
				order++;//이 조건문에 들어왔다는 건 무조건 하나의 작업이 끝난다는 것이므로 완료 작업 갯수를 늘려줌.
				//우선순위가 제일 높은 녀석이라면 작업 가능.
				
				//우선순위큐와 작업 큐에서 각각 하나씩 빼줌.
				Document pollDocument = jobOrder.poll();
				priorityque.poll();
				if (pollDocument.isTarget) {//빼낸 작업이 원하는 타겟이라면. 당장 멈춰도 됨.
					//System.out.println(order);
					break;
				}
			} else {
				//우선순위가 제일 높은 녀석이 아니므로 큐의 제일 뒤로 보내줌.
				jobOrder.add(jobOrder.poll());// 빼서 제일 뒤로.
			}
		}
		return order;
	}
}

class Document {
	boolean isTarget = false;
	int priority;

	public Document(int priority, boolean isTarget) {
		this.priority = priority;
		this.isTarget = isTarget;
	}
}