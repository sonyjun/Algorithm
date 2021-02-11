package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoThreeDimension {//백준 토마토. 7569번
	static int[][][] box;
	static int zeroNum;
	static int visitCount = 0;
	static int callNum = 0;
	static int[] dI = { -1, 1, 0, 0, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1, 0, 0 };
	static int[] dT = { 0, 0, 0, 0, -1, 1 };
	static int M;
	static int N;
	static int H;
	static Queue<PositionTT> que = new LinkedList<PositionTT>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N + 1][M + 1][H + 1];
		int minusNum = 0;
		int oneNum = 0;
		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 1; m <= M; m++) {
					box[n][m][h] = Integer.parseInt(st.nextToken());
					if (box[n][m][h] == -1) {
						minusNum++;
					} else if (box[n][m][h] == 1) {
						oneNum++;
						que.add(new PositionTT(n, m, h));
					}
				}
			}
		}
		zeroNum = M * N * H - oneNum - minusNum;
		BFS();
		if(zeroNum == 0) {
			System.out.println(0);
		}else if (visitCount == zeroNum) {
			System.out.println(callNum-1);
		}else {
			System.out.println(-1);
		}
	}

	public static void BFS() {
		callNum++;
		ArrayList<PositionTT> arrayList = new ArrayList<PositionTT>();
		while (!que.isEmpty()) {
			PositionTT pollPos = que.poll();
			for (int i = 0; i < 6; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				int nextT = pollPos.t + dT[i];
				// 범위 밖 패스
				if (nextI < 1 || nextJ < 1 || nextT < 1 || nextJ > M || nextI > N
						|| nextT > H) {
					continue;
				}
				// 범위 내에 있고, -1이나 1(방문)이 아니라면,
				if (box[nextI][nextJ][nextT] != -1 && box[nextI][nextJ][nextT] != 1) {
					box[nextI][nextJ][nextT] = 1;
					arrayList.add(new PositionTT(nextI, nextJ, nextT));
					visitCount++;
				}
			}
		}
		for (PositionTT p : arrayList) {
			que.add(p);
		}
		if (!que.isEmpty()) {
			BFS();
		}
	}
}

class PositionTT {
	int i = 0;
	int j = 0;
	int t = 0;

	public PositionTT(int i, int j, int t) {
		this.i = i;
		this.j = j;
		this.t = t;
	}
}
