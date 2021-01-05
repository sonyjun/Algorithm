package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DirectorShom2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 1;
		if (num == 1) {
			System.out.println("666");
		} else {
			for (int i = 667;; i++) {
				int temp = i;
				while (temp > 0) {
					if (temp % 1000 == 666) {
						count++;
						break;
					}
					temp = temp/10;
				}
				if(count == num) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
