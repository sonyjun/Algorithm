package DevideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiplication { // 백준 곱셈. 1629번
	static long c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		System.out.println(calcPow(a, b) % c);
	}

	public static long calcPow(long a, long b) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		if (b % 2 == 0) {// 짝수라면
			long temp = calcPow(a, b / 2);
			temp %= c;
			return (temp * temp) % c;
		} else {// 홀수라면
			return calcPow(a, b - 1) * a;
		}
	}
}
