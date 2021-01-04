package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alphabet {

	static int[] dI = { -1, 1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int maxCount = 0;

	public static void main(String args[]) throws Exception {
		boolean[] AlphaChecked = new boolean[100];// +65 하면 됨 or -65하면 됨.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[r][c];
		char[][] field = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				field[i][j] = str.charAt(j);
			}
		}

		AlphaChecked[field[0][0]] = true;
		DFS(field, AlphaChecked, 0, 0, 1);
		/*for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(maxCount);
	}

	public static void DFS(char[][] field, boolean[] AlphaChecked, int startI, int startJ, int count) {
		//System.out.println("이번 방문건 : "+field[startI][startJ]);
		if (maxCount < count) {
			maxCount = count;
		}
		for (int i = 0; i < 4; i++) {
			int nextI = startI + dI[i];
			int nextJ = startJ + dJ[i];

			// 범위 밖 패스
			if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
				continue;
			}
			// 1이 아니면 방문 ㄴㄴ
			if (AlphaChecked[field[nextI][nextJ]] == false) {
				AlphaChecked[field[nextI][nextJ]] = true;
				DFS(field, AlphaChecked, nextI, nextJ, count + 1);
				AlphaChecked[field[nextI][nextJ]] = false;
			}
		}
	}
}

class PositionA {
	int i;
	int j;

	public PositionA(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
