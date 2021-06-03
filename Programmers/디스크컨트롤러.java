package Programmers;

import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Job> que = new PriorityQueue<Job>();
		boolean[] checked = new boolean[jobs.length];
		// 초기작업.
		int average = 0;
		int time = 0;
		int checkJob = 0;
		while (checkJob < jobs.length) {//모든 작업이 스케쥴러에 다 들어가면 종료.
			
			//0초를 시작으로 시간이 흘러감에따라 요청시간에 시작 가능한 작업을 스케쥴러에 넣음.
			for (int i = 0; i < jobs.length; i++) {
				if (jobs[i][0] <= time && checked[i] == false) {
					checked[i] = true;
					checkJob++;
					que.add(new Job(i, jobs[i][0],jobs[i][1]));
				}
			}
			
			if(que.isEmpty()) {//요청된 작업이 없는 경우, 그냥 시간이 흐름.
				time++;
			}else {//요청된 작업이 있는 경우. 하나의 작업을 수행해줘야 다음 시간 계산이 가능.
				Job pollJob = que.poll();
				time += pollJob.length;//해당 작업이 끝난 시간.
				average += time - pollJob.startTime;
			}
		}
		while(!que.isEmpty()) {
			Job pollJob = que.poll();
			time += pollJob.length;//해당 작업이 끝난 시간.
			average += time - pollJob.startTime;
		}
		return average/jobs.length;
	}
}

class Job implements Comparable<Job> {
	int num;
	int length;
	int startTime;

	public Job(int num, int startTime, int length) {
		this.num = num;
		this.length = length;
		this.startTime = startTime;
	}

	public int compareTo(Job j) {
		return this.length - j.length;
	}
}