package PrioirtyQueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsHeap {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else if (Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else {
					return o1 - o2;
				}

			}

		});
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
