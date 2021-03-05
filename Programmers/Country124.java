package Programmers;

public class Country124 {
	public static void main(String[] args) {
		// System.out.println(solution(3));
		System.out.println(solution(15));
		// System.out.println(solution(4));
		// System.out.println(solution(11));
		// System.out.println(solution(15));
	}

	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			// 3의 배수일 때 처리 해줘야함.
			int temp = n % 3;
			if (temp == 0) {
				sb.insert(0, 4);
			} else if (temp == 1) {
				sb.insert(0, 1);
			} else if (temp == 2) {
				sb.insert(0, 2);
			}
			if (n % 3 == 0) {
				n = n / 3 - 1;
			}else {
				n = n / 3;// 일의 자리 부터 구하고 하나씩 짤라내는 과정.
			}
		}
		return sb.toString();
	}
}
