package PracticeCoding;

import java.util.ArrayList;

public class Algorithm1 {
	public static void main(String args[]) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		int[] answer = solution(numbers);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] numbers) {
		// int[] answer = new int[((numbers.length) * (numbers.length - 1)) / 2];
		// int index = 0;
		ArrayList<Integer> arr = new ArrayList();
		int num = 0;

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				// answer[index++] = numbers[i] + numbers[j];
				num = numbers[i] + numbers[j];
				if (!arr.contains(num)) {
					arr.add(num);
				}
			}
		}
		int[] answer = new int[arr.size()];
		//if (2 <= answer.length && answer.length <= 100) {
			for (int i = 0; i < answer.length; i++) {
				answer[i] = arr.get(i);
			}
		//}
		sort(answer);
		return answer;
	}

	public static void sort(int[] data) {
		int size = data.length;
		int min; // 최소값을 가진 데이터의 인덱스 저장 변수
		int temp;

		for (int i = 0; i < size - 1; i++) { // size-1 : 마지막 요소는 자연스럽게 정렬됨
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
	}
}