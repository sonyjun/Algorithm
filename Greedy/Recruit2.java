package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Recruit2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			solution(num);
		}
	}

	public static void solution(int num) throws Exception {
		if (num == 1) {
			System.out.println(1);
			return;
		}

		int[] ranking = new int[num + 1];
		int answer = 1;// 첫번째 시험 1등

		for (int i = 1; i <= num; i++) {
			String[] str = br.readLine().split(" ");
			int first = Integer.parseInt(str[0]);
			int sec = Integer.parseInt(str[1]);
			ranking[first] = sec;
		}

		loop: for (int i = 2; i <= num; i++) {
			int score = ranking[i];
			// 첫번째 시험 3 4 두번째 시험 2 1
			if (score == 1) {
				answer++;
				continue;
			}

			for (int j = i - 1; j > 0; j--) {
				if (ranking[j] < score)
					continue loop;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
