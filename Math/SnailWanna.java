package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnailWanna {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());// 낮에 올라가는
		int B = Integer.parseInt(st.nextToken());// 밤에 내려가는
		int V = Integer.parseInt(st.nextToken());// 최종 단계
		int x = 0;
		if ((V - A) % (A - B) == 0) {
			x = (V - A) / (A - B);
		} else {
			x = (V - A) / (A - B) + 1;
		}
		x++;
		System.out.println(x);
	}
}
