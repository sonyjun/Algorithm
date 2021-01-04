package Greedy;

import java.util.Arrays;

public class SaveBoat2 {
	public static void main(String args[]) {
		SaveBoat2Solution s = new SaveBoat2Solution();
		int[] people1 = { 70, 50, 80, 50 };
		int limit1 = 100;
		int[] people2 = { 10, 20, 30, 40, 50, 50, 60, 70, 80, 90 };
		int limit2 = 100;
		System.out.println(s.solution(people1, limit1));
		System.out.println(s.solution(people2, limit2));
	}
}

class SaveBoat2Solution {
	public int solution(int[] people, int limit) {

		Arrays.sort(people);
		int i = 0, j = people.length - 1;
		//여기서 i는 같이 타는 사람의 수를 나타냄.
		//즉 people.length가 뜻하는 한사람당 하나씩 보트를 탈경우(최대)에서 같이타는 사람의 수를 빼면
		//최종 필요한 보트의 개수가 나오게 됨.
		for (; i < j; --j) {// i와 j가 같은경우는 같이 못타는 걸로 분류 됨. 고려대상이 아님.
			if (people[i] + people[j] <= limit)
				++i;
		}
		
		return people.length - i;
	}
}
