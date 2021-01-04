package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
	public static void main(String args[]) {
		DiskControllerSolution d = new DiskControllerSolution();
		int[][] jobs1 = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		int[][] jobs2 = { { 0, 5 }, { 6, 2 }, { 6, 1 } };
		int[][] jobs3 = { { 0, 9 }, { 0, 4 }, { 0, 5 }, { 0, 7 }, { 0, 3 } };

		int[][] jobs4 = { { 0, 5 }, { 6, 1 }, { 6, 2 } };
		int[][] jobs5 = { { 0, 5 }, { 2, 2 }, { 5, 3 } };
		int[][] jobs6 = { { 0, 5 }, { 2, 2 }, { 4, 2 } };
		int[][] jobs7 = { { 0, 3 }, { 0, 1 }, { 4, 7 } };
		int[][] jobs8 = { { 0, 2 }, { 3, 6 }, { 3, 1 } };
		int[][] jobs9 = { { 0, 5 }, { 1, 2 }, { 5, 5 } };
		int[][] jobs10 = { { 1, 9 }, { 1, 4 }, { 1, 5 }, { 1, 7 }, { 1, 3 } };
		System.out.println(d.solution(jobs10));
	}
}

class DiskControllerSolution {
	public int solution(int[][] jobs) {
		// 우선순위 큐는 서비스 시간이 가장 짧은 걸 선택해주는 큐.
		// -> 해당시간이 되었을 때 짧은 작업을 선택하기 위한 자료구조,
		// 작업배열 processArr는 요청시간을 오름차순으로 정렬.
		// -> 요청시간을 보고 실행이 가능한 녀석들을 우선순위 큐에 넣기 위한 자료구조.
		PriorityQueue<Process> priorityQue = new PriorityQueue<Process>();
		// 우선순위 큐는 서비스시간이 짧은게 먼저 poll되도록 설계.

		Process[] processArr = new Process[jobs.length];
		//활용 가능한 부분, 큐 이긴한데, 우선순위가 먼저 들어온게 먼저나가고 이런게 아닌 경우. 
		//배열을 선언해놓고 사용한건 인덱스를 증가시켜줌으로써 활용 가능!!!
		
		
		for (int i = 0; i < jobs.length; i++) {// 요청시간, 서비스시간으로 구성된 객체.
			processArr[i] = new Process(jobs[i][0], jobs[i][1]);
		}
		Arrays.sort(processArr, new Comparator<Process>() {// 프로세스의 요청시간을 오름차순으로 정렬
															// 요청시간이 같을 경우 정렬 신경안써도 되는 이유는 우선순위 큐에서 걸러지기 때문.
			@Override
			public int compare(Process o1, Process o2) {
				if (o1.startTime > o2.startTime)
					return 1;
				else {
					return -1;
				}
			}

		});

		int time = 0;
		int jobIndex = 0;
		while (!priorityQue.isEmpty() || jobIndex < processArr.length) {//우선순위 큐가 비어있지 않다면,, 잡스케쥴러가 프로세스를 모두 실행시키지않았다면.
			for (int i = jobIndex; i < processArr.length; i++) {
				if (processArr[i].startTime <= time) {//지금 시간을 고려하여 바로 실행 될 수 있는 프로세스가 있다면 우선순위 큐에 추가.
					priorityQue.add(processArr[i]);
					jobIndex++;
				}
			}
			if (priorityQue.isEmpty()) {// 시간을 고려하여 지금 바로 실행 될 수 있는 프로세스가 없다면 공백시간 고려하여 추가. 
										// 문제의 제한사항으로 CPU사용 가능할 경우 가장 먼저 요청한 작업이 먼저 수행.
				time += processArr[jobIndex].startTime - time;//공백 시간 고려한 계산.
				priorityQue.add(processArr[jobIndex]);
				jobIndex++;
			} else {
				Process temp = priorityQue.poll();
				time += temp.serviceTime;// 들어온 작업 끝낫을 때 시간으로 설정.
				temp.fromStartToEnd = time - temp.startTime;// 요청시간부터 완료까지 걸린 시간.
			}
		}

		int average = 0;
		for (int i = 0; i < processArr.length; i++) {
			average += processArr[i].fromStartToEnd;
		}

		return average / processArr.length;
	}
}

class Process implements Comparable<Process> {
	int startTime;
	int serviceTime;
	int fromStartToEnd;

	public Process(int startTime, int serviceTime) {
		this.startTime = startTime;
		this.serviceTime = serviceTime;
	}

	@Override
	public int compareTo(Process o) {
		// TODO Auto-generated method stub
		if (this.serviceTime >= o.serviceTime) {
			return 1;
		} else {
			return -1;
		}
	}
}