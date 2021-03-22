package Programmers;

import java.util.ArrayList;

public class Level3_7_2 {
	static boolean[][][] field;
	static ArrayList<int[]> resultList;

	public static void main(String[] args) {
		solution(5, new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } });
		System.out.println();
		solution(5, new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } });
	}

	public static int[][] solution(int n, int[][] build_frame) {
		field = new boolean[n + 1][n + 1][2];
		resultList = new ArrayList<int[]>();
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];// x좌표
			int y = build_frame[i][1];// y좌표
			int whatObejct = build_frame[i][2];// 기둥(0), 보(1)
			int installOrDelete = build_frame[i][3];// 설치(1), 삭제(0)
			if (whatObejct == 0 && installOrDelete == 1) {// 기둥 설치
				if (isPillarPossible(x, y)) {
					field[x][y][0] = true;
					resultList.add(new int[] { x, y, 0 });
				}
			}
			if (whatObejct == 0 && installOrDelete == 0) {// 기둥 삭제
				field[x][y][0] = false;//일단 지웠다고 표시.
				//전체 인덱스 탐색 오래걸리니. 좌표 인덱스 따로 관리.
				for (int t = 0; t < resultList.size(); t++) {
					int[] temp = resultList.get(t);
					if (temp[0] == x && temp[1] == y && temp[2] == 0) {
						resultList.remove(t);
						break;
					}
				}//좌표 인덱스에서 지우려는 것 삭제하고, 일관성 여부 확인.
				
				if (!check()) {// 지워는게 불가능하다면,
					field[x][y][0] = true;
					resultList.add(new int[] { x, y, 0 });
				}
			}
			if (whatObejct == 1 && installOrDelete == 1) {// 보 설치
				if (isBoPossible(x, y)) {
					field[x][y][1] = true;
					resultList.add(new int[] { x, y, 1 });
				}
			}
			if (whatObejct == 1 && installOrDelete == 0) {// 보 삭제
				field[x][y][1] = false;//일단 지웠다고 표시.
				//전체 인덱스 탐색 오래걸리니. 좌표 인덱스 따로 관리.
				for (int t = 0; t < resultList.size(); t++) {
					int[] temp = resultList.get(t);
					if (temp[0] == x && temp[1] == y && temp[2] == 1) {
						resultList.remove(t);
						break;
					}
				}//좌표 인덱스에서 지우려는 것 삭제하고, 일관성 여부 확인.
				
				if (!check()) {// 지워는게 불가능하다면,
					field[x][y][1] = true;
					resultList.add(new int[] { x, y, 1 });
				}

			}
		}
		resultList.clear();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j][0]) {
					resultList.add(new int[] { i, j, 0 });
				}
				if (field[i][j][1]) {
					resultList.add(new int[] { i, j, 1 });
				}
			}
		}
		int[][] answer = new int[resultList.size()][3];
		for (int i = 0; i < resultList.size(); i++) {
			int[] temp = resultList.get(i);
			answer[i][0] = temp[0];
			answer[i][1] = temp[1];
			answer[i][2] = temp[2];
			System.out.println(answer[i][0] + "," + answer[i][1] + "," + answer[i][2]);
		}
		return answer;
	}

	public static boolean isPillar(int x, int y) {//범위 체크 해줌. 쓸데없이 벗어나느 공간 체크하는 것 방지 위함.
		if (x < 0 || y < 0 || x >= field.length || y >= field[0].length) {// 범위 체크.
			return false;
		}
		return field[x][y][0];
	}

	public static boolean isBo(int x, int y) {//범위 체크 해줌. 쓸데없이 벗어나느 공간 체크하는 것 방지 위함.
		if (x < 0 || y < 0 || x >= field.length || y >= field[0].length) {// 범위 체크.
			return false;
		}
		return field[x][y][1];
	}

	public static boolean isPillarPossible(int x, int y) {//해당 위치에 기둥 지을 수 있는지.
		// 기둥이 바닥 위인지, 보가 설치되었는지(왼쪽 끝, 오른쪽 끝) , 아래가 기둥인지.
		if (y == 0 || isBo(x, y) || isBo(x - 1, y) || isPillar(x, y - 1)) {
			return true;
		}
		return false;
	}

	public static boolean isBoPossible(int x, int y) {//해당 위치에 보 지을 수 있는지.
		// 아래가 기둥인지, 양끝이 보인지, 오른쪽 아래가 기둥인지
		if (isPillar(x, y - 1) || (isBo(x - 1, y) && isBo(x + 1, y)) || isPillar(x + 1, y - 1)) {
			return true;
		}
		return false;
	}

	public static boolean check() {//삭제 했을 경우, 나머지 좌표들이 원래 역할을 할 수 있는지 체크.
		for (int i = 0; i < resultList.size(); i++) {
			int[] temp = resultList.get(i);
			if (temp[2] == 0) {
				if (!isPillarPossible(temp[0], temp[1])) {
					return false;
				}
			}
			if (temp[2] == 1) {
				if (!isBoPossible(temp[0], temp[1])) {
					return false;
				}
			}
		}
		return true;
	}
}

class Construct {
	int i;
	int j;
	int object;

	public Construct(int i, int j, int object) {
		this.i = i;
		this.j = j;
		this.object = object;
	}
}
