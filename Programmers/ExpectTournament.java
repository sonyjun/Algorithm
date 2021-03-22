package Programmers;

public class ExpectTournament {
	public static void main(String[] args) {
		solution(8, 5, 7);
	}

	public static int solution(int n, int a, int b) {
		int smallNPerson = Math.min(a, b);
		int bigNPerson = Math.max(a, b);
		int round = 0;
		while (true) {
			round++;
			if (bigNPerson - 1 == smallNPerson && smallNPerson % 2 == 1) {
				// 차이가 하나나고, 작은 쪽이 홀수쪽일 때 둘은 붙는 상태임.
				break;
			}
			bigNPerson = (bigNPerson + 1) / 2;
			smallNPerson = (smallNPerson + 1) / 2;
		}
		//System.out.println(round);
		return round;
	}
}
