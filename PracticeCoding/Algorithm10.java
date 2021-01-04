package PracticeCoding;

import java.util.LinkedList;
import java.util.Scanner;

//https://engineering.linecorp.com/ko/blog/2019-firsthalf-line-internship-recruit-coding-test/
public class Algorithm10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int co = sc.nextInt();
		int br = sc.nextInt();

		int pos[] = new int[200001]; // 값을 min 초 취급
		int answer = -1;

		LinkedList<Integer> qu = new LinkedList<>();

		qu.add(br);// 최초 브라운의 위치 넣어줌

		while (!qu.isEmpty()) {
			int brPosition = qu.poll();
			
			int coPosition = co + (pos[brPosition] * (pos[brPosition]+1))/2 ;
			
			if(brPosition == coPosition) {
				answer = pos[brPosition];
				break;
			}
			int caseOne = brPosition - 1;
			int caseTwo = brPosition + 1;
			int caseThree = brPosition * 2;
			
			if (caseOne >= 0 && pos[caseOne] == 0 && caseOne <= 200000) {
				pos[caseOne] = pos[brPosition] + 1; // pos[brPosition]의 해당 위치까지 도달하는데 걸리는 시간이 들어있음!
				qu.add(caseOne);
			}

			if (caseTwo >= 0 && pos[caseTwo] == 0 && caseTwo <= 200000) {
				pos[caseTwo] = pos[brPosition] + 1;
				qu.add(caseTwo);
			}

			if (caseThree >= 0 && pos[caseThree] == 0 && caseThree <= 200000) {
				pos[caseThree] = pos[brPosition] + 1;
				qu.add(caseThree);
			}

		}
		System.out.println(answer);
	}
}
