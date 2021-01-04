package PracticeCoding;
//https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
public class Algorithm15 {
	public static void main(String args[]) {
		int[] prices = { 1, 2, 3, 2, 3 };
		Solution15 s15 = new Solution15();
		s15.solution(prices);
	}
}

class Solution15 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int temp = prices[i];
			for (int j = i + 1; j < prices.length; j++) {
				if (temp <= prices[j]) {
					// count++;
					answer[i] = j - i;
				} else {
					answer[i] = j - i;
					break;
				}
			}
		}
		return answer;
	}
}
