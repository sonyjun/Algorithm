package BinarySearch;

import java.util.Arrays;

public class EnterCheck {
	public static void main(String args[]) {
		EnterCheckSolution e = new EnterCheckSolution();
		e.solution(6, new int[] { 7, 10 });
	}
}

class EnterCheckSolution {
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long left = 1;
		long right = (long)times[times.length - 1] * n;
		long mid = 0;
		long answer = Long.MAX_VALUE;
		 while (left != right) {
			mid = (left + right) / 2;
			if (binarySearch(times, mid, n)) {
				//이걸 만족한다는 건 수용인원이 n보다 크거나 같다는 것. 
				//같다는 것이 시간이 가장 적을 테니 여길 들어오는 mid값의 최소값이 정답.
				// mid아래 범위로 줄여라
				answer = answer > mid ? mid : answer;
				right = mid - 1;
			} else {
				// mid위의 범위로 줄여라
				left = mid + 1;
			}
		}
		System.out.println(answer);
		return answer;
	}

	public boolean binarySearch(int[] times, long mid, int n) {
		// true면 mid아래범위 , false면 mid 위에 범위
		// mid는 시간을 나타냄, 최소의 시간을 갖는 입국심사자에게 최대한 할당하며 갯수 체크.
		long personCount = 0;
		for (int i = 0; i < times.length; i++) {
			personCount += mid / times[i];
		}
		if (personCount >= n) {
			//수용해야하는 인원인 n보다 크거나 같은경우는 시간이 정확하거나 좀 더 줄일수 있는 경우.
			return true;
			//왼쪽 범위로 줄여라
			//personCount는 최대로 받을수 있는 인원수 인데, 목표 인원보다 많은 경우는 시간을 줄여야하기 때문.
		} else {
			return false;
			//오른쪽 범위로 줄여라
			//personCount는 최대로 받을수 있는 인원수 인데, 목표 인원보다 적은 경우는 시간을 늘려야하기 때문.
		}
	}
}