package PracticeCoding;

public class Algorithm12 {
	public static void main(String args[]) {
		Solution12 s12 = new Solution12();
		int n = 6;
		int[] p = { 5, 4, 7, 2, 0, 6 };
		int[] c = { 4, 6, 4, 9, 2, 3 };
		s12.solution(n, p, c);

		int n1 = 7;
		int[] p1 = { 6, 2, 1, 0, 2, 4, 3 };
		int[] c1 = { 3, 6, 6, 2, 3, 7, 6 };
		s12.solution(n1, p1, c1);
	}
}

class Solution12 {
	public String solution(int n, int[] p, int[] c) {
		String answer;
		int currentPrice = 100;
		int money = 0;
		int delayCount = 0;
		int[] realC = new int[c.length];
		boolean beforeOk = true;

		for (int i = 0; i < p.length - 1; i++) {
			if (p[i] >= c[i]) { // 생산량이 더 크면,
				realC[i] = c[i];
				p[i + 1] += p[i] - c[i];
			} else {
				realC[i] = 0;
				p[i + 1] += p[i];
			}
		}
		realC[c.length - 1] = p[p.length - 1];
		if (realC[c.length - 1] - c[p.length - 1] > 0) {
			realC[c.length - 1] = c[p.length - 1];
		} else {
			realC[c.length - 1] = 0;
		}

		for (int i = 0; i < realC.length; i++) {
			if (delayCount == 0) {// 이전에 못팔았다는 뜻.
				money += realC[i] * currentPrice;
			} else if (delayCount == 1) {
				currentPrice = 50;
				money += realC[i] * currentPrice;
				beforeOk = false;
			} else if (delayCount == 2) {
				currentPrice = 25;
				money += realC[i] * currentPrice;
				beforeOk = false;
			} else {
				System.out.println("i");
				n = i;
			}

			if (realC[i] == 0) {
				delayCount++;
			} else {// 만약 0이 아니라면 이전 값이 어땠는지 확인.
				if (beforeOk == false) {
					beforeOk = true;
					delayCount = 0;
					currentPrice = 100;
				}
			}
		}

		answer = String.format("%.2f", (float) (money / n));

		return answer;
	}
}