package Greedy;

import java.util.Arrays;

public class SaveBoat {
	public static void main(String args[]) {
		SaveBoatSolution s = new SaveBoatSolution();
		int[] people1 = { 70, 50, 80, 50 };
		int limit1 = 100;
		int[] people2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int limit2 = 100;
		System.out.println(s.solution(people1, limit1));
		System.out.println(s.solution(people2, limit2));
	}
}

class SaveBoatSolution {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int leftIdx = 0;
		int rightIdx = people.length - 1;
		int boatCount = 0;
		while (leftIdx < rightIdx) {
			if (people[rightIdx] + people[leftIdx] <= limit) {
				leftIdx++;
				rightIdx--;
				boatCount++;
			} else {
				rightIdx--;
				boatCount++;
			}
		}
		if (leftIdx == rightIdx) {
			return boatCount+1;
		} else {
			return boatCount;
		}
	}
}
