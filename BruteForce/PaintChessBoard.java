package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintChessBoard {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] chessBoard = new int[m + 1][n + 1];

		// 체스판 W(흰색)는 1로, B(검은색)는 0으로 나타냄.
		for (int i = 1; i <= m; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == 'W') {
					chessBoard[i][j + 1] = 1;
				}
			}
		}
		// 뭐가 최적일지 판단.

		// 왼쪽 위를 흰색(1)으로 칠할 경우.
		int minCount = Integer.MAX_VALUE;
		for (int startI = 1; startI <= m - 7; startI++) {
			for (int startJ = 1; startJ <= n - 7; startJ++) {
				//System.out.println(startI + "," + startJ);
				int count = 0;
				for (int i = startI; i <= startI + 7; i++) {
					for (int j = startJ; j <= startJ + 7; j++) {
						if (i % 2 == 1) {// 홀수 열일 경우.
							if (j % 2 == 1 && chessBoard[i][j] == 0) {// 홀수 열에 홀수 행일 경우, 검정이라면 흰색 칠해야지.
								count++;
							}
							if (j % 2 == 0 && chessBoard[i][j] == 1) {// 홀수 열에 짝수 행일 경우, 흰색이라면 검정 칠해야지.
								count++;
							}
						} else {// 짝수 열일 경우.
							if (j % 2 == 1 && chessBoard[i][j] == 1) {// 짝수 열에 홀수 행일 경우, 흰색이라면 검정 칠해야지.
								count++;
							}
							if (j % 2 == 0 && chessBoard[i][j] == 0) {// 짝수 열에 짝수 행일 경우, 검정이라면 흰색 칠해야지
								count++;
							}
						}
					}
				}
				minCount = Math.min(count, minCount);
				count = 0;
				// 왼쪽 위를 검은색(0)으로 칠할 경우.
				for (int i = startI; i <= startI + 7; i++) {
					for (int j = startJ; j <= startJ + 7; j++) {
						if (i % 2 == 1) {// 홀수 열일 경우.
							if (j % 2 == 1 && chessBoard[i][j] == 1) {// 홀수 열에 홀수 행일 경우, 흰색이라면 검정 칠해야지.
								// System.out.println("i :"+i+", j :"+j);
								count++;
							}
							if (j % 2 == 0 && chessBoard[i][j] == 0) {// 홀수 열에 짝수 행일 경우, 검정이라면 흰색 칠해야지.
								// System.out.println("i :"+i+", j :"+j);
								count++;
							}
						} else {// 짝수 열일 경우.
							if (j % 2 == 1 && chessBoard[i][j] == 0) {// 짝수 열에 홀수 행일 경우, 검정이라면 흰색 칠해야지.
								// System.out.println("i :"+i+", j :"+j);
								count++;
							}
							if (j % 2 == 0 && chessBoard[i][j] == 1) {// 짝수 열에 짝수 행일 경우, 흰색이라면 검정 칠해야지.
								// System.out.println("i :"+i+", j :"+j);
								count++;
							}
						}
					}
				}
				minCount = Math.min(count, minCount);
			}
		}
		System.out.println(minCount);

		/*
		 * for (int i = 1; i <= m; i++) { for (int j = 1; j <= n; j++) {
		 * System.out.print(chessBoard[i][j] + " "); } System.out.println(); }
		 */
	}
}
