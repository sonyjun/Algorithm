package RecursiveCall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		System.out.println(fibo(x));
	}

	public static int fibo(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		return fibo(x - 1) + fibo(x - 2);
	}
}
