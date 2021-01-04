package PracticeCoding;

import java.util.Stack;
// 크레인 인형 뽑기.

public class Algorithm2 {
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(s.solution(board, moves));
	}
}

class Solution2 {
	public int solution(int[][] board, int[] moves) {
		Stack<Integer> bucket = new Stack<Integer>();
		int boomCount = 0;
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				int seletedSelItem = board[j][moves[i]-1];
				if (seletedSelItem != 0) {//0이 아닌값, 즉,인형이 있다면,
					if(!bucket.isEmpty()) {//stack 비었는지 확인.
						if (bucket.peek() == seletedSelItem) {
							bucket.pop();
							boomCount += 2;
						}
						else {
							bucket.push(seletedSelItem);
						}
					}else {//stack 비어있으니 그냥 추가
						bucket.push(seletedSelItem);
					}
					board[j][moves[i]-1] = 0;
					break;
				}
			}
		}
		return boomCount;
	}
}