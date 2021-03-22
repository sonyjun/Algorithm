package Programmers;

public class N_numLCM {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 6, 8, 14 }));
		System.out.println(solution(new int[] { 1, 2, 3 }));
	}

	public static int solution(int[] arr) {
		int answer = arr[0];
		for (int i = 1; i < arr.length; i++) {
			answer = getLCM(answer,arr[i]);
		}
		return answer;
	}

	public static int getGCD(int a, int b) {
		while (b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

	public static int getLCM(int a, int b) {
		return (a * b) / getGCD(a, b);
	}
}
