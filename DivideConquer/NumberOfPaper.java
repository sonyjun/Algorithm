package DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfPaper {// 백준 종이의 개수. 1780번
	static int[][] paperArr;
	static int minusPaper = 0;
	static int zeroPaper = 0;
	static int onePaper = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paperArr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				paperArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divideConquer(1, 1, n);
		System.out.println(minusPaper);
		System.out.println(zeroPaper);
		System.out.println(onePaper);
	}

	public static void divideConquer(int startI, int startJ, int size) {
		//System.out.println("startI : "+startI+", startJ: "+startJ+" size : "+size);
		int minusCount = 0;
		int zeroCount = 0;
		int oneCount = 0;
		for (int i = startI; i < startI + size; i++) {
			for (int j = startJ; j < startJ + size; j++) {
				if (paperArr[i][j] == 0) {
					zeroCount++;
				} else if (paperArr[i][j] == 1) {
					oneCount++;
				} else {
					minusCount++;
				}
			}
		}

		if (zeroCount == 0 && oneCount > 0 && minusCount == 0) {
			onePaper++;
			return;
		} else if (zeroCount > 0 && oneCount == 0 && minusCount == 0) {
			zeroPaper++;
			return;
		} else if (zeroCount == 0 && oneCount == 0 && minusCount > 0) {
			minusPaper++;
			return;
		} else {
			divideConquer(startI, startJ, size / 3);
			divideConquer(startI + size / 3, startJ, size / 3);
			divideConquer(startI + size / 3 + size / 3, startJ, size / 3);

			divideConquer(startI , startJ+ size / 3, size / 3);
			divideConquer(startI + size / 3 , startJ+ size / 3, size / 3);
			divideConquer(startI + size / 3 + size / 3, startJ+ size / 3, size / 3);

			divideConquer(startI , startJ + size / 3 + size / 3, size / 3);
			divideConquer(startI + size / 3, startJ + size / 3 + size / 3, size / 3);
			divideConquer(startI + size / 3 + size / 3, startJ + size / 3 + size / 3, size / 3);
		}
	}
}
