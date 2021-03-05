package Programmers;

public class TrainingClothes {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 }));
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 }));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] howManyHave = new int[n];
		for (int i = 0; i < howManyHave.length; i++) {
			howManyHave[i] = 1;
		}
		for (int i = 0; i < lost.length; i++) {
			howManyHave[lost[i] - 1]--;
		}

		for (int i = 0; i < reserve.length; i++) {
			howManyHave[reserve[i] - 1]++;
		}

		for (int i = 0; i < howManyHave.length; i++) {
			if (howManyHave[i] > 1) {// 빌려줄 수 있는 녀석이면.
				if (i - 1 >= 0 && howManyHave[i - 1] == 0) {// 왼쪽 먼저 보고 빌려줌.
					howManyHave[i]--;
					howManyHave[i - 1]++;
					continue;
				}
				if (i + 1 < howManyHave.length && howManyHave[i + 1] == 0) {// 오른쪽 빌려줌
					howManyHave[i]--;
					howManyHave[i + 1]++;
					continue;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < howManyHave.length; i++) {
			if (howManyHave[i] != 0) {
				answer++;
			}
		}

		return answer;
	}
}
