package Programmers;

public class NextBigNum {
	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

	public static int solution(int n) {
		int oneNum = 0;
		String temp = Integer.toBinaryString(n);
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '1') {
				oneNum++;
			}
		}
		int answer = n;
		while (true) {
			answer += 1;
			int count = 0;
			temp = Integer.toBinaryString(answer);
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '1') {
					count++;
				}
			}
			if(count == oneNum) {
				return answer;
			}
		}
	}
}
