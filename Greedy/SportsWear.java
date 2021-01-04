package Greedy;

public class SportsWear {
	public static void main(String args[]) {
		SportsWearSolution s = new SportsWearSolution();
		int n1 = 5;
		int[] lost1 = { 2, 4 };
		int[] reserve1 = { 1, 3, 5 };
		int n2 = 5;
		int[] lost2 = { 2, 4 };
		int[] reserve2 = { 3 };
		int n3 = 3;
		int[] lost3 = { 3 };
		int[] reserve3 = { 1 };

		s.solution(n1, lost1, reserve1);
		s.solution(n2, lost2, reserve2);
		s.solution(n3, lost3, reserve3);
	}
}

class SportsWearSolution {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] studentState = new int[n];
		// 0 : 본인 체육복만 있는 사람 or 빌려서 이제 체육활동 가능한 사람.
		// 1 : 본인 체육복+여분
		// -1 : 도난당한 사람
		int possibleCount = n - lost.length;
		for (int i = 0; i < lost.length; i++) {
			studentState[lost[i] - 1] = -1;
		}
		for (int i = 0; i < reserve.length; i++) {
			if(studentState[reserve[i] - 1] == -1 ) {
				studentState[reserve[i] - 1] = 0;
				possibleCount++;
			}else {
				studentState[reserve[i] - 1] = 1;
			}
		}

		if (studentState[0] == 1 && studentState[1] == -1) {// 첫사람은 다음사람만 보면 됨.
			studentState[0] = 0;
			studentState[1] = 0;
			possibleCount++;
		}
		if (studentState[n - 1] == 1 && studentState[n - 2] == -1) {// 마지막 사람은 전사람만 보면 됨.
			studentState[n - 1] = 0;
			studentState[n - 2] = 0;
			possibleCount++;
		}
		for (int i = 1; i < n - 1; i++) {// n은 무조건 2명 이상.
			if (studentState[i] == 1 && studentState[i - 1] == -1) {// 본인 전사람이 도난당했따면 빌려줌
				studentState[i] = 0;
				studentState[i - 1] = 0;
				possibleCount++;
				continue;
			}
			if (studentState[i] == 1 && studentState[i + 1] == -1) {// 본인 다음사람이 도난당했따면 빌려줌
				studentState[i] = 0;
				studentState[i + 1] = 0;
				possibleCount++;
			}
		}
		//System.out.println(possibleCount);
		return possibleCount;
	}
}