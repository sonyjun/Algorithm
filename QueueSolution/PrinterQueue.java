package QueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= testCaseNum; i++) {
			st = new StringTokenizer(br.readLine());
			int documentNum = Integer.parseInt(st.nextToken());// 문서의 갯수.
			int targetNum = Integer.parseInt(st.nextToken());// 몇번째로 출력되는지 알려는 문서의 위치.
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			Queue<Number> que = new LinkedList<Number>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < documentNum; j++) {// j번째 문서이고 중요도가 documentPrior이다.
				int documentPrior = Integer.parseInt(st.nextToken());
				priorityQueue.add(documentPrior);
				if (j == targetNum) {
					que.add(new Number(documentPrior, true));
				} else {
					que.add(new Number(documentPrior, false));
				}
			}
			//System.out.println(priorityQueue);
			
			int index = 0;
			while (!que.isEmpty()) {// 이제 우선순위를 보고 차례대로 작업을 처리할 차례.
				if (que.peek().priority == priorityQueue.peek()) {// 우선순위가 본인차례가 맞으므로 빼도 된다면!
					index++;//몇번째로 빠지는지 확인을 위해
					Number pollNum = que.poll();
					priorityQueue.poll();
					if (pollNum.target == true) {
						sb.append(index+"\n");
						break;
					}
				} else {// 아직 본인이 빠질 차례가 아니라면,
					que.add(que.poll());
				}
			}
		}
		System.out.println(sb);
	}
}

class Number{
	int priority = 0;
	boolean target = false;

	public Number(int priority, boolean target) {
		this.priority = priority;
		this.target = target;
	}
}