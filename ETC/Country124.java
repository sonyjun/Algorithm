package ETC;

public class Country124 {
	public static void main(String args[]) {
		Country124Solution c = new Country124Solution();
		c.solution(9);
	}
}

class Country124Solution {
	public String solution(int n) {
		String answer = "";
		String[] order = { "4", "1", "2" };
		while (n > 0) {
			answer = order[n % 3] + answer;
			n = (n - 1) / 3;// n-1을 하는 이유는 자리올림을 안하는 효과를 내기 위함.
		}
		System.out.println(answer);
		return answer;
	}
}