package Programmers;

public class StockPrice {
	public static void main(String[] args) {
		int[] answer = solution(new int[] { 1, 2, 3, 2, 3, 1 });
		int[] answer1 = solution(new int[] { 5, 8, 6, 2, 4, 1 });
		for (int i : answer) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : answer1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length - 1; i++) {
			int count = 1;
			int currentPrices = prices[i];
			// System.out.println(currentPrices);
			for (int j = i + 1; j < prices.length - 1; j++) {
				if (currentPrices <= prices[j]) {// 유지되는 구간 체크
					count++;
				}else {
					break;
				}
			}
			answer[i] = count; // 총 걸리는 시간 - i 초후 - 본인보다 작은 주가.
		}
		answer[prices.length - 1] = 0;
		return answer;
	}
}
