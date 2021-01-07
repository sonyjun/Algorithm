package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sudoku {
	static int[][] field;
	static boolean[][] row;
	static boolean[][] column;
	static boolean[][] square;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		field = new int[9][9];
		row = new boolean[9][10];// row[i][a] i번째행에 a의 값이 있다.
		column = new boolean[9][10];// column[i][a] i번째열에 a의 값이 있다.
		square = new boolean[9][10];// 0~8번째 사각형
		// 0 1 2
		// 3 4 5
		// 6 7 8
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				field[i][j] = num;
				row[i][num] = true;
				column[j][num] = true;
				square[(i / 3) * 3 + (j / 3)][num] = true;
			}
		}
		DFS(0);
		/*
		 * for (int i = 0; i < 9; i++) { for (int j = 0; j < 9; j++) {
		 * System.out.print(field[i][j]); } System.out.println(); }
		 */

	}

	public static void DFS(int cnt) {
		count++;
		int x = cnt / 9;
		int y = cnt % 9;
		// System.out.println(cnt);
		if (cnt == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(field[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		if (field[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (row[x][i] == false && column[y][i] == false && square[(x / 3) * 3 + (y / 3)][i] == false) {
					field[x][y] = i;
					row[x][i] = true;
					column[y][i] = true;
					square[(x / 3) * 3 + (y / 3)][i] = true;
					DFS(cnt + 1);
					field[x][y] = 0;
					row[x][i] = false;
					column[y][i] = false;
					square[(x / 3) * 3 + (y / 3)][i] = false;
				} // 1~9까지 아무것도 들어갈 수 없는 순간이 오면 재귀문이 종료됨. 스도쿠의 원리지.
					// 뭐라도 들어갈 수 있으면 그 숫자를 넣고 다음 탐색이 이루어짐.
					// 이렇게 들어갈 수 있는 숫자를 다 탐색해서 81이 나오면, 모든 탐색이 이상없이 끝난걸로 볼 수 있다.
					// 81이 넘지 않고 끝나는 건 이 조건문에 못 걸린 거임. 즉 1~9까지 모두 넣을 수 없는 순간이 온거지.
			}
		} else {
			DFS(cnt + 1);// 0이 아니므로 신경쓸 값이 아님.
		}
	}
}