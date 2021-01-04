package Search;

public class Exam {
	public static void main(String args[]) {
		ExamSolution e = new ExamSolution();
		// int[] answer1 = { 1, 2, 3, 4, 5 };
		int[] answer2 = { 1, 3, 2, 4, 2 };
		// e.solution(answer1);
		e.solution(answer2);
	}
}

class ExamSolution {
	public int[] solution(int[] answers) {
		int max = Integer.MIN_VALUE;
		int[] answer;
		int[] correctArr = new int[3];
		int[] person1Pattern = { 1, 2, 3, 4, 5 };
		int[] person2Pattern = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3Pattern = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person1Pattern[i % 5]) {
				correctArr[0]++;
			}
		}
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person2Pattern[i % 8]) {
				correctArr[1]++;
			}

		}
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person3Pattern[i % 10]) {
				correctArr[2]++;
			}
		}

		for (int i = 0; i < correctArr.length; i++) {
			if (max < correctArr[i]) {
				max = correctArr[i];
			}
		}

		int sameCount = 0;
		for (int i = 0; i < correctArr.length; i++) {
			if (max == correctArr[i]) {
				sameCount++;
			}
		}
		answer = new int[sameCount];
		sameCount = 0;
		for (int i = 0; i < correctArr.length; i++) {
			if (correctArr[i] == max) {
				answer[sameCount++] = i + 1;
			}
		}

		return answer;
	}
}