package Programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			que.add(scoville[i]);
		}
		int count = 0;
		while (que.size() > 1 && que.peek() < K) {
			count++;
			int pollNum1 = que.poll();
			int pollNum2 = que.poll();
			que.add(pollNum1 + (pollNum2 * 2));
		}
		if(que.peek() >= K) {
			return count;
		}else {
			return -1;
		}
	}
}
