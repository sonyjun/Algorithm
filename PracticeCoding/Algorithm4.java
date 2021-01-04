package PracticeCoding;

import java.util.LinkedList;

public class Algorithm4 {
	public static void main(String args[]) {
		Solution4 s4 = new Solution4();
		int[] test;
		test = s4.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("");
		test = s4.solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("");
	}
}

class Solution4 {
	public int[] solution(int[] progresses, int[] speeds) {

		LinkedList<Integer> que = new LinkedList<Integer>();
		LinkedList<Integer> answer = new LinkedList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] == 0) {
				que.add((100 - progresses[i]) / speeds[i]);
			} else {
				que.add((100 - progresses[i]) / speeds[i] + 1);
			}
		}
		while (!que.isEmpty()) {
			int num = que.poll();
			int count = 1;
			if(!que.isEmpty()) {
				while(num >= que.peek()) {
					que.poll();
					count++;
					if(que.isEmpty())
						break;
				}
			}
			answer.add(count);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
/*	public int[] solution(int[] progresses, int[] speeds) {

	Stack<Integer> stack = new Stack<Integer>();
	LinkedList<Integer> answer = new LinkedList<Integer>();

	for (int i = progresses.length-1 ; i > 0 ; i--) {
		if ((100 - progresses[i]) % speeds[i] == 0) {
			stack.add((100 - progresses[i]) / speeds[i]);
		} else {
			stack.add((100 - progresses[i]) / speeds[i] + 1);
		}
		System.out.println("  sdf");
	}
	System.out.println(stack);
	while (!stack.isEmpty()) {
		int num = stack.pop();
		int count = 1;
		while(num >= stack.peek()) {
			stack.pop();
			count++;
			if(stack.isEmpty())
			break;
			
		}
		
		answer.add(count);
	}

	return answer.stream().mapToInt(i -> i).toArray();*/
}