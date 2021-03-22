package Programmers;

public class ReverseThree {
	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution(125));
	}

	public static int solution(int n) {
		int answer = 0;
		String temp = "";
		while (n > 0) {
			temp = temp + n % 3;
			n = n / 3;
		}
		for (int i = 0; i < temp.length(); i++) {
			answer += Math.pow(3, temp.length() - i - 1) * Integer.parseInt(temp.charAt(i) + "");
		}
		return answer;
	}
}
