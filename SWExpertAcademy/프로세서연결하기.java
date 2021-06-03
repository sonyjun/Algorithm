package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다. 이러한 상황에서도 동일하게
 * java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class 프로세서연결하기 {
	static int[][] field;
	static ArrayList<int[]> corePos;
	static int maxCoreNum = Integer.MIN_VALUE;
	static int minWireLen = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		StringBuilder sb= new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			field = new int[N + 1][N + 1];
			corePos = new ArrayList<int[]>();
			maxCoreNum = Integer.MIN_VALUE;
			minWireLen = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					field[i][j] = num;
					// 가장자리 제외한 코어만
					if (num == 1 && i != 1 && j != 1 && i != N && j != N) {
						corePos.add(new int[] { i, j });
					}
				}
			}
			go(0, 0, 0);
			sb.append("#"+test_case+" "+minWireLen+"\n");
/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
/////////////////////////////////////////////////////////////////////////////////////////////

		}
		System.out.println(sb);
	}

	public static void go(int index, int coreN, int wireLen) {
		if (index == corePos.size()) {
			if (maxCoreNum < coreN) {
				maxCoreNum = coreN;
				minWireLen = wireLen;
			} else if (maxCoreNum == coreN) {
				minWireLen = Math.min(minWireLen, wireLen);
			}
			return;
		}
		int[] pos = corePos.get(index);
		for (int i = 0; i < 4; i++) {
			if (isPossible(i, pos[0], pos[1])) {
				int wireCount = setWire(i, pos[0], pos[1], 3);
				go(index + 1, coreN + 1, wireLen + wireCount);
				//다음 코어의 위치 살펴봐야하고, 작동 코어 하나 증가, 전선 길이 증가.
				setWire(i, pos[0], pos[1], 0);
			}
		}
		go(index + 1, coreN, wireLen);// 아예 셀이 작동을 안한경우.
	}
	public static boolean isPossible(int direction, int startI, int startJ) {
		switch (direction) {
		case 0: {// 왼쪽
			for (int j = startJ - 1; j >= 1; j--) {
				if (field[startI][j] != 0) {
					return false;
				}
			}
			return true;
		}
		case 1: {// 오른쪽
			for (int j = startJ + 1; j < field[0].length; j++) {
				if (field[startI][j] != 0) {
					return false;
				}
			}
			return true;
		}
		case 2: {// 위
			for (int i = startI - 1; i >= 1; i--) {
				if (field[i][startJ] != 0) {
					return false;
				}
			}
			return true;
		}
		case 3: {// 아래
			for (int i = startI + 1; i < field.length; i++) {
				if (field[i][startJ] != 0) {
					return false;
				}
			}
			return true;
		}
		}
		return true;
	}
	public static int setWire(int direction, int startI, int startJ, int color) {
		int wireCount = 0;
		switch (direction) {
		case 0: {// 왼쪽
			for (int j = startJ - 1; j >= 1; j--) {
				wireCount++;
				field[startI][j] = color;
			}
			return wireCount;
		}
		case 1: {// 오른쪽
			for (int j = startJ + 1; j < field[0].length; j++) {
				field[startI][j] = color;
				wireCount++;
			}
			return wireCount;
		}
		case 2: {// 위
			for (int i = startI - 1; i >= 1; i--) {
				field[i][startJ] = color;
				wireCount++;
			}
			return wireCount;
		}
		case 3: {// 아래
			for (int i = startI + 1; i < field.length; i++) {
				field[i][startJ] = color;
				wireCount++;
			}
			return wireCount;
		}
		}

		return wireCount;
	}
}