package QueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SpinQueue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int queueSize = Integer.parseInt(st.nextToken());
		int selectNumSize = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] selectArr = new int[selectNumSize];
		for(int i = 0 ; i < selectArr.length ; i++) {
			selectArr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 1; i <= queueSize; i++) {
			deque.add(i);
		}
		int operCount = 0;
		for (int i = 0; i < selectArr.length; i++) {
			int currentNum = selectArr[i];
			while (!deque.isEmpty()) {
				int tempCount = 0;
				while(deque.peek() != currentNum) {// Head랑 찾으려는 값이 같을 때까지 왼쪽으로 밀어냄. 
					deque.addLast(deque.pollFirst());
					tempCount++;
				}
				if(tempCount <= deque.size() - tempCount) {// 같은 값을 찾았다면, 왼쪽으로 밀어낸것과 오른쪽으로 밀어냈을 때와 비교해서 작은걸 횟수에 카운트를 함.
					operCount += tempCount;
				}else {
					operCount += deque.size() - tempCount;
				}
				deque.pollFirst();//찾으려는 값을 que에서 빼줌.
				break;
			}
		}
		System.out.println(operCount);
	}
}
