package Programmers;

import java.math.BigInteger;

public class NormalSquare {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static long solution(int w, int h) {
		int GCD = gcd(w, h);
		int minW = w / GCD;
		int minH = h / GCD;
		int cantUse = minW + minH - 1;
		int totalcantUse = cantUse * GCD;
		String wStr = w+"";
		String hStr = h+"";
		String totalcantUseStr = totalcantUse+"";
		BigInteger wBig = new BigInteger(wStr);
		BigInteger hBig = new BigInteger(hStr);
		BigInteger totalBig = new BigInteger(totalcantUseStr);
		//System.out.println(wBig.toString());
		wBig = wBig.multiply(hBig);
		//System.out.println(wBig.toString());
		wBig = wBig.subtract(totalBig);
		long answer = Long.parseLong(wBig.toString());
		return answer;
	}

	public static int gcd(int a, int b) { // 최대공약수
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
