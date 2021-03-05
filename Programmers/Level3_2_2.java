package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_2_2 {

	static int[][] gameBoard;
	static boolean[][] visited;

	public static void main(String[] args) {
		System.out.println(new int[][] { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } });
	}

	public static int solution(int[][] board) {
		gameBoard = board;
		visited = new boolean[board.length][board.length];
		int answer = 0;
		return answer;
	}

	public void DFS(RobotPosition NextrobotPosition) {
		// 오른쪽, 왼쪽, 아래 , 위, 회전.. 각자 할짓 다해보고 경로 없으면 중단.
		// 오른쪽
		int rightI = NextrobotPosition.rightI;
		int rightJ = NextrobotPosition.rightJ + 1;
		if (rightI < gameBoard.length && rightJ < gameBoard.length && gameBoard[rightI][rightJ] != 1) {
			visited[NextrobotPosition.leftI][NextrobotPosition.leftJ] = true;
			DFS(new RobotPosition(NextrobotPosition.rightI, NextrobotPosition.rightJ, rightI, rightJ));
			visited[NextrobotPosition.leftI][NextrobotPosition.leftJ] = false;
		}

		// 왼쪽
		int leftI = NextrobotPosition.leftI;
		int leftJ = NextrobotPosition.leftJ -1;
		if (leftI < gameBoard.length && leftJ < gameBoard.length && gameBoard[leftI][leftJ] != 1) {
			visited[NextrobotPosition.rightI][NextrobotPosition.rightJ] = true;
			DFS(new RobotPosition(leftI, leftJ, NextrobotPosition.leftI, NextrobotPosition.leftJ));
			visited[NextrobotPosition.rightI][NextrobotPosition.rightJ] = false;
		}

		// 아래
		int topLeftI = NextrobotPosition.leftI + 1;
		int topLeftJ = NextrobotPosition.leftJ + 1;
		int topRightI = NextrobotPosition.leftI + 1;
		int topRightJ = NextrobotPosition.leftJ + 1;
		if (leftI < gameBoard.length && leftJ < gameBoard.length && gameBoard[leftI][leftJ] != 1) {
			visited[NextrobotPosition.rightI][NextrobotPosition.rightJ] = true;
			DFS(new RobotPosition(leftI, leftJ, NextrobotPosition.rightJ, NextrobotPosition.rightJ));
		}

		// 위

		// 회전 4개 방향..
	}
}

class RobotPosition {
	int leftI;
	int leftJ;
	int rightI;
	int rightJ;

	public RobotPosition(int leftI, int leftJ, int rightI, int rightJ) {
		this.leftI = leftI;
		this.leftJ = leftJ;
		this.rightI = rightI;
		this.rightJ = rightJ;
	}
}