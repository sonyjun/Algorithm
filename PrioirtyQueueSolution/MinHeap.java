package PrioirtyQueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {// 백준 최소 힙. 1927
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (!priorityQue.isEmpty()) {
					sb.append(priorityQue.poll() + "\n");
				} else {
					sb.append("0\n");
				}
			} else {
				priorityQue.add(input);
			}
		}
		System.out.println(sb);
	}
}
