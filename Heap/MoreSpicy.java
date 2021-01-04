package Heap;

import java.util.PriorityQueue;

public class MoreSpicy {
	public static void main(String args[]) {
		MoreSpicySolution m = new MoreSpicySolution();
		int[] scoville = { 1, 2, 3, 4, 5 };
		int K = 7;
		System.out.println(m.solution(scoville, K));
	}
}
//우선 순위 큐는 들어간 순서에는 상관없이, 우선순위가 높은 원소기준으로 정렬되는 것이다.
class MoreSpicySolution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> priorityQue = new PriorityQueue<Integer>();
		for (int t : scoville) {
			priorityQue.add(t);
		}
		int count = 0;
		while (priorityQue.peek() < K) {
			int temp1 = priorityQue.poll();
			if (priorityQue.isEmpty()) {//즉 큐에 하나만 남았을 경우.. 합칠것도 없고 결국 스코빌 지수 못넘긴거.
				return -1;
			}
			int temp2 = priorityQue.poll();
			temp1 = temp1 + temp2 * 2;
			priorityQue.add(temp1);
			count++;
		}
		return count;
	}
}

/*
 * class MoreSpicySolution { public int solution(int[] scoville, int K) {
 * ArrayList<Integer> arrlist = new ArrayList<Integer>(); Arrays.sort(scoville);
 * for (int t : scoville) { arrlist.add(t); } int count = 0 ; while
 * (arrlist.get(0) < K) { arrlist.set(0, arrlist.get(0) + arrlist.get(1) * 2);
 * arrlist.remove(1); Collections.sort(arrlist); count++; } return count; } }
 */
