package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix {
	static int[][] matrixA;
	static int[][] matrixB;
	static boolean[][] isSame;
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrixA = new int[N + 1][M + 1];
		matrixB = new int[N + 1][M + 1];
		isSame = new boolean[N + 1][M + 1];
		for (int j = 1; j <= N; j++) {
			String inputStr = br.readLine();
			for (int t = 1; t <= M; t++) {
				matrixA[j][t] = Integer.parseInt(inputStr.charAt(t - 1) + "");
			}
		}
		for (int j = 1; j <= N; j++) {
			String inputStr = br.readLine();
			for (int t = 1; t <= M; t++) {
				matrixB[j][t] = Integer.parseInt(inputStr.charAt(t - 1) + "");
				if (matrixA[j][t] == matrixB[j][t]) {
					isSame[j][t] = true;
				}
			}
		}
		if (N < 3 || M < 3) {
			boolean same = true;
			for (int j = 1; j <= N; j++) {
				for (int t = 1; t <= M; t++) {
					if(isSame[j][t] == false) {
						same = false;
					}
				}
			}
			if(same) {
				System.out.println(0);
			}else {
				System.out.println(-1);
			}
		} else {
			System.out.println(getAnswer());
		}
	}

	public static int getAnswer() {
		int count = 0;
		for (int i = 1; i <= N - 2; i++) {
			for (int j = 1; j <= M - 2; j++) {
				if (i == N - 2 && !(isSame[i][j] == isSame[i + 1][j] && isSame[i][j] == isSame[i + 2][j])) {
					return -1;
				}
				if (j == M - 2 && !(isSame[i][j] == isSame[i][j + 1] && isSame[i][j] == isSame[i][j + 2])) {
					return -1;
				}
				if (isSame[i][j] == false) {
					getReverse(i, j);
					count++;
				}
			}
		}
		// 제일 마지막 2*2 체크해줘야지..
		for (int i = N - 2; i <= N; i++) {
			for (int j = M - 2; j <= M; j++) {
				if (isSame[i][j] == false) {
					return -1;
				}
			}
		}
		return count;
	}

	public static void getReverse(int startI, int startJ) {
		for (int i = startI; i <= startI + 2; i++) {
			for (int j = startJ; j <= startJ + 2; j++) {
				if (isSame[i][j] == true) {
					isSame[i][j] = false;
				} else {
					isSame[i][j] = true;
				}
			}
		}
	}
}
/*
 * 3 4 0000 0010 0001 1001 1011 1001
 */
