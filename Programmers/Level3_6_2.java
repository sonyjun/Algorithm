package Programmers;

public class Level3_6_2 {
	public static void main(String[] args) {
		solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3);
		solution(new int[] { 2 }, 1);
	}

	public static int solution(int[] stones, int k) {
		int answer = 1;
		int left = 1;
		int right = 200000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isPossible(stones, mid, k)) {
				// 최대 값을 찾아야 하니까. mid가 된다면 left를 옮겨서 더 큰 값 찾아야지.
				// left, right를 옮겨가면서 mid에 해당되는 사람의 수를 다 찾아서 최대값을 갱신.
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else {
				// 최대 값을 찾아야 하니까. mid가 안된다면 right를 옮겨서 범위를 줄어야함.
				right = mid - 1;
			}
		}
		//System.out.println(answer);
		return answer;
	}

	public static boolean isPossible(int[] stones, int mid, int k) {

		// 연속된 0의 갯수를 세는 것.
		int zeroCount = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] < mid) {
				zeroCount++;
				if (zeroCount >= k) {
					return false;
				}
			} else {
				zeroCount = 0;
			}
		}
		return true;
	}
}
