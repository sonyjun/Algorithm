package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://aorica.tistory.com/126 참고.
public class Centauri {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		String[] str = new String[testCaseNum];
		for (int i = 0; i < testCaseNum; i++) {
			str[i] = br.readLine();
		}

		for (int t = 0; t < testCaseNum; t++) {
			StringTokenizer st = new StringTokenizer(str[t]);
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			long length = y - x;
			long i = 1;
			for (;; i++) {
				if (length < i * i)
					break;
			} // 거리보다 큰 제곱을 구함. 그걸 기준으로 최소비용을 구해야되기 때문에.
				// 현재 구하려는 거리보다 큰 i의 값과 i-1의 값의 중간값 보다 작다면,
			if ((i - 1) * (i - 1) == length) {
				System.out.println(2 * i - 3);
			} else if (length <= ((i * i) + (i - 1) * (i - 1)) / 2) {
				// 본인이 포함된 범위의 최소값과 같다면,
				System.out.println(2 * i - 2);
			} else {
				System.out.println(2 * i - 1);
			}
		}
	}
}
