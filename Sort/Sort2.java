package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numArr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(numArr[i]+"\n");
		}
		System.out.println(sb);
	}
}
