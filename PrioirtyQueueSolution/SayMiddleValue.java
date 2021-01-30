package PrioirtyQueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class SayMiddleValue {// 백준 가운데를 말해요. 1655번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxPriorityQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minPriorityQue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int inputNum = Integer.parseInt(br.readLine());// 받아온 값
			

			//두개의 힙에 균형을 맞춰주기 위한 행동. 
			//그런데 사이즈가 같으면 max힙에 넣는 이유는, 그렇게 되면 max힙의 peek가 중간값이 될 수 있음(스왑 가정을 거쳐야 겟찌만)
			if (maxPriorityQue.size() == minPriorityQue.size()) {
				maxPriorityQue.add(inputNum);
			} else {
				minPriorityQue.add(inputNum);
			}
			
			//swap의 목적, 올바른 위치에 들어갈 수 있게 하기 위함. 
			//중간값의 최소값이 max heap에 있도록하여 max heap의 peek가 중간값 혹은 중간값의 최소값이 되게 하기 위함.
			if(!maxPriorityQue.isEmpty() && !minPriorityQue.isEmpty()) {
				if(maxPriorityQue.peek() > minPriorityQue.peek()) {
					int temp = maxPriorityQue.poll();
					maxPriorityQue.add(minPriorityQue.poll());
					minPriorityQue.add(temp);
				}
			}
			sb.append(maxPriorityQue.peek()+"\n");
		}
		System.out.println(sb);
	}
}
