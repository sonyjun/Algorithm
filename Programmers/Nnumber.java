package Programmers;

public class Nnumber {
	public static void main(String[] args) {
		solution(2, 4, 2, 1);
		solution(16, 16, 2, 1);
		solution(16, 16, 2, 2);
		//System.out.println(Integer.toString(10, 11));
	}

	public static String solution(int n, int t, int m, int p) {
		String result = "0";
		int i = 1;
		while (result.length() < t * m) {
			// i를 n진수로 바꿔야함.
			result += Integer.toString(i,n);
			i++;
		}
		result = result.substring(0, t * m);

		String answer = "";
		for (int j = p - 1; j < result.length(); j += m) {
			answer += result.charAt(j);
		}
		//System.out.println(answer);
		return answer.toUpperCase();
	}
}
