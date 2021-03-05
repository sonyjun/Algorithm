package Programmers;

import java.util.Stack;

public class CrawMachinGame {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<Integer>();
		int answer = 0;
		for (int i = 0; i < moves.length; i++) {// 모든 움직임을 다 받아들임.
			int position = moves[i] - 1;// 뽑으려는 위치.
			for (int j = 0; j < board.length; j++) {
				if (board[j][position] != 0) {// 만약 뽑으려는 위치를 쭉 내려가다 인형을 만난다면,
					int getDollNum = board[j][position];// 뽑게된 인형.
					board[j][position] = 0;// 뽑힌 인형의 위치는 0으로 세팅.
					if (!stack.isEmpty()) {// 바구니가 비어있지 않다면,
						if (stack.peek() == getDollNum) {// 바구니 제일 위에 인형과 뽑은 인형이 같다면,
							stack.pop();
							answer += 2;// 터졌다고 기록.
						} else {// 바구니 제일 위에 인형과 뽑은 인형이 다르다면,
							stack.add(getDollNum);
						}
					} else {// 바구니가 비었으면 그냥 넣음.
						stack.add(getDollNum);
					}
					break;
				}
				// 뽑을 인형이 없으면 끝까지 돌다가 끝남.
			}
		}
		return answer;
	}
}
