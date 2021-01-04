package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMhotel {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		String[] str = new String[testCaseNum];
		for (int i = 0; i < testCaseNum; i++) {
			str[i] = br.readLine();
		}
		for (int i = 0; i < testCaseNum; i++) {
			StringTokenizer st = new StringTokenizer(str[i]);
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int y = 0;
			int x = 0;
			if (n % h == 0) {
				y = h;
				x = n / h;
			} else {
				y = n % h;
				x = n / h + 1;
			}
			String answer = y+"";
			if (x < 10) {
				answer += 0+""+x;
			}else {
				answer += x;
			}
			System.out.println(answer);
		}
	}
}
