package RecursiveCall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTop {
	static int count = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(n, 1, 2, 3);
		System.out.println(count + "\n" + sb);
	}

	public static void hanoi(int n, int start, int mid, int end) {
		count++;
		if (n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		hanoi(n - 1, start, end, mid);
		sb.append(start + " " + end + "\n");
		hanoi(n - 1, mid, start, end);
	}
}
