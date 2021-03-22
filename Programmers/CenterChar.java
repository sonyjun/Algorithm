package Programmers;

public class CenterChar {
	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}

	public static String solution(String s) {
		if (s.length() % 2 == 0) {
			return s.charAt(s.length() / 2 - 1) + "" + s.charAt(s.length() / 2);
		} else {
			return s.charAt(s.length() / 2) + "";
		}
	}
}
