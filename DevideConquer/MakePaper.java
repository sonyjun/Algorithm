package DevideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakePaper {// 백준 색종이 만들기. 2630번
	static int[][] paper;
	static int onePaperCount = 0;//파란색 종이 개수
	static int zeroPaperCount = 0;//하얀색 종이 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n + 1][n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(paper[i][j] + " ");
			}
			System.out.println();
		}*/
		divide(1, 1, n);
		System.out.println(zeroPaperCount);
		System.out.println(onePaperCount);
	}

	public static void divide(int startI, int startJ, int size) {
		// 이 공간이 만약 둘 중에 하나로 전부 칠해져 있다면.. return해야겟네.
		int numZero = 0;
		int numOne = 0;
		
		//종이에 0과 1을 카운트
		for (int i = startI; i < startI+ size; i++) {
			for (int j = startJ; j < startJ + size; j++) {
				if (paper[i][j] == 1) {
					numOne++;
				} else {
					numZero++;
				}
			}
		}
		if (numZero == 0 && numOne > 0) {// 1로만 칠해져 있다면
			onePaperCount++;
			return;
		} else if (numZero > 0 && numOne == 0) {// 0으로만 칠해져 있다면
			zeroPaperCount++;
			return;
		}else {// 0 또는 1이 같이 섞여 있는 경우 4등분해서 재귀호출.
			divide(startI, startJ, size / 2);
			divide(startI + (size / 2), startJ, size / 2);
			divide(startI, startJ + (size / 2), size / 2);
			divide(startI + (size / 2), startJ + (size / 2), size / 2);
		}
	}
}
/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 1 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
*/