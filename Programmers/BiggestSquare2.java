package Programmers;

public class BiggestSquare2 {
	static int[][] staticBoard;
	static int maxSize = Integer.MIN_VALUE;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } }));
		System.out.println(solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } }));
		System.out.println(solution(new int[][] { { 1 } }));
		System.out.println(solution(new int[][] { { 0 } }));
	}

	public static int solution(int[][] board) {
		staticBoard = board;
		maxSize = Integer.MIN_VALUE;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					makeSquare(i, j);
				}
			}
		}
		if(maxSize == Integer.MIN_VALUE) {
			return 0;
		}else {
			return maxSize;
		}
	}

	public static void makeSquare(int startI, int startJ) {
		int index = 0;
		while (true) {
			index++;
			maxSize = Math.max(maxSize, index * index);
			for (int i = startJ; i <= startJ + index; i++) {// 오른쪽으로 채우는 녀석.
				if (startI + index >= staticBoard.length || i >= staticBoard[0].length) {
					return;
				}
				if (staticBoard[startI + index][i] == 0) {
					return;
				}
			}
			for (int j = startI; j < startI + index; j++) {// 아래로 채우는 녀석.
				if (startJ + index >= staticBoard[0].length || j >= staticBoard.length) {
					return;
				}
				if (staticBoard[j][startJ + index] == 0) {
					return;
				}
			}
		}
	}
}
