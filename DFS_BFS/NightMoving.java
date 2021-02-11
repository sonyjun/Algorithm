package DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NightMoving {// 백준 나이트의 움직임. 7562번

	static int[] dI = { -2, -1, -2, 1, 2, -1, 1, 2 };
	static int[] dJ = { -1, -2, 1, -2, -1, 2, 2, 1 };
	static Queue<PositionN> que;
	static int[][] chessBoard;
	static int count = 0;
	static int endI;
	static int endJ;
	static int startI;
	static int startJ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {
			int chessSize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			startI = Integer.parseInt(st.nextToken());
			startJ = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endI = Integer.parseInt(st.nextToken());
			endJ = Integer.parseInt(st.nextToken());
			count = 0;
			chessBoard = new int[chessSize][chessSize];
			que = new LinkedList<PositionN>();
			chessBoard[startI][startJ] = 1;
			que.add(new PositionN(startI, startJ));
			BFS();
			bw.write(count-1 + "\n");
		}
		bw.close();
	}

	public static void BFS() {
		ArrayList<PositionN> arrayList= new ArrayList<PositionN>();
		count++;
		while (!que.isEmpty()) {
			PositionN pollPos = que.poll();
			if (pollPos.i == endI && pollPos.j == endJ) {
				arrayList.clear();
				que.clear();
				break;
			}
			for (int i = 0; i < 8; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				// 범위 밖 패스
				if (nextI < 0 || nextJ < 0 || nextI >= chessBoard.length || nextJ >= chessBoard.length) {
					continue;
				}
				if (chessBoard[nextI][nextJ] == 0) {
					chessBoard[nextI][nextJ] = 1; // 방문했다고 표시.
					arrayList.add(new PositionN(nextI, nextJ));
				}
			}
		}
		for(PositionN p : arrayList) {
			que.add(p);
		}
		if(!que.isEmpty()) {
			BFS();
		}
	}
}

/*
 * 1 8 0 0 7 0
 */

class PositionN {
	int i;
	int j;

	PositionN(int i, int j) {
		this.i = i;
		this.j = j;
	}
}