package RecursiveCall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrawStar {
	static boolean[][] starArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		starArr = new boolean[x][x];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				sb.append(makeStar(i, j, x));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static String makeStar(int i, int j, int num) {
		if ((i / num) % 3 == 1 && (j / num) % 3 == 1) {
			return " ";
		} else {
			if (num / 3 == 0) {
				return "*";
			} else {
				return makeStar(i, j, num / 3);
			}
		}
	}
}
