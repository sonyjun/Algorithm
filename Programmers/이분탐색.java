package Programmers;

public class 이분탐색 {
	public static void main(String[] args) {
		Solution이분탐색 s = new Solution이분탐색();
		System.out.println(s.solution(11, new int[] { 1, 100 }));
		System.out.println(s.solution(3, new int[] { 1, 1, 1 }));
		System.out.println(s.solution(3, new int[] { 1, 2, 3 }));
	}
}

class Solution이분탐색 {
	public long solution(int n, int[] times) {
		long longTime = Long.MAX_VALUE;
		for (int i = 0; i < times.length; i++) {
			longTime = Math.min(longTime, times[i]);
		}
		long maxTime = longTime * n;
		// left,right는 각각 시간 범위를 나타냄.
		long leftIndex = 0;
		long rightIndex = maxTime;
		long mid = 0;
//		System.out.println("호출");
		while (leftIndex < rightIndex) {
			mid = leftIndex + (rightIndex - leftIndex) / 2;
//			System.out.println("mid : " + mid);
			int possiblePerson = calPersonNum(mid, times);
//			System.out.println("가능인원 : " + possiblePerson);
			if (possiblePerson >= n) {
				rightIndex = mid;
			} else {
				leftIndex = mid + 1;
			}
		}
		return leftIndex + (rightIndex - leftIndex) / 2;
	}

	public int calPersonNum(long mid, int[] times) {// mid라는 시간에 입국 심사를 할 수 있는 최대 인원 반환.
		int sum = 0;
		for (int i = 0; i < times.length; i++) {
			sum += mid / times[i];
		}
		return sum;
	}
}