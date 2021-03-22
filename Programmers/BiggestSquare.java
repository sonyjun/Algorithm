package Programmers;

public class BiggestSquare {
	static int[][] staticBoard;
	static int maxSize = Integer.MIN_VALUE;

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } }));
		System.out.println(solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } }));
		System.out.println(solution(new int[][] { { 1 } }));
		System.out.println(solution(new int[][] { { 0 } }));
	}

	public static int solution(int[][] board) {
		staticBoard = new int[board.length + 1][board[0].length + 1];
		maxSize = Integer.MIN_VALUE;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				staticBoard[i + 1][j + 1] = board[i][j];
			}
		}
		for (int i = 1; i < staticBoard.length; i++) {
			for (int j = 1; j < staticBoard[0].length; j++) {
				if (staticBoard[i][j] == 1) {
					staticBoard[i][j] = Math.min(staticBoard[i - 1][j - 1],
							Math.min(staticBoard[i - 1][j], staticBoard[i][j - 1])) + 1;
					maxSize = Math.max(maxSize, staticBoard[i][j]);
				}
			}
		}
		return maxSize*maxSize;
	}
}
