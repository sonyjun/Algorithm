package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HoneyHouse {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if (num == 1) {
			System.out.println(1);
		} else {
			int start = 2;
			int end = 7;
			int count = 2;
			while (true) {
				//System.out.println("start : " + start);
				//System.out.println("end : " + end);
				if (start <= num && num <= end) {
					System.out.println(count);
					break;
				}
				int temp = end - start;
				start = end + 1;
				end = start + temp + 6;
				count++;
			}
		}
	}
}
