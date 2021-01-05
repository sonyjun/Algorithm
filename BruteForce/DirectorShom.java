package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DirectorShom {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int startNum = 666;
		int patternN = num / 18; // 6661 ~ 6669 이런게 몇버 나왔는가.
		System.out.println("patternN:"+patternN);
		int head = 0;
		int start6N = 0;
		if (num > 18) {
			head = num - 9 * patternN - 1;// 666의 앞자리를 구하는 식.
			start6N = 18 * patternN + 7;
			String str = head+"";
			System.out.println(head);
			if(str.charAt(str.length()-1) == '6') {
				System.out.println("계산 들어가야지");
			}else {
				System.out.println("헤드로 계산 가능");
			}
		} else {
			head = num - 1;// 666의 앞자리를 구하는 식.
			start6N = 7;
		}
	}
}
