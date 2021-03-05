package Programmers;

public class TargetNum {
	static int answer = 0;
	static int[] staticNumbers;

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	public static int solution(int[] numbers, int target) {
		staticNumbers = numbers;
		DFS(0, 0, target);
		return answer;
	}

	public static void DFS(int searchI, int sum, int target) {
		if (searchI >= staticNumbers.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		DFS(searchI + 1, sum + staticNumbers[searchI], target);
		DFS(searchI + 1, sum - staticNumbers[searchI], target);
	}
}
