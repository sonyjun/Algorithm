package Programmers;

public class Capet {
	public static void main(String[] args) {
		int[] answer1 = solution(10, 2);
		int[] answer2 = solution(8, 1);
		int[] answer3 = solution(24, 24);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;
		for (int i = 3; i <= sum; i++) {
			if (sum % i == 0) {
				int num1 = i;
				int num2 = sum / i;
				if ((num1 + num2) * 2 - 4 == brown) {
					answer[1] = num1;
					answer[0] = num2;
					break;
				}
			}
		}
		System.out.println(answer[0]+","+answer[1]);
		return answer;
	}
}
