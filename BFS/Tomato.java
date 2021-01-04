package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Tomato {

	static Queue<PositionT> que;
	static int day = 0;
	static int Visitcount = 0;
	static int zeroCount = 0;

	public static void main(String args[]) throws Exception {
		que = new LinkedList<PositionT>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] adjArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());

				if (adjArr[i][j] == 1) {
					que.add(new PositionT(i, j, 0));
					// 1이 여러개일 경우, 동시에 익는 과정이 진행되야 하므로, que에 미리 다 넣는 과정이 필요함.
					// 그러면 번갈아 실행되면서 같이 동시에 익어나가는 듯한 효과를 볼 수 있음.
				}
				if (adjArr[i][j] == 0) {
					zeroCount++;
					// 0의 갯수와 BFS방문 횟수를 비교해 모든것이 익었는지 확인하기 위함.
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}

		BFS(adjArr);// 1이 들어간 que를 다 채웠으니 BFS를 실행.

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void BFS(int[][] adjArr) {
		while (!que.isEmpty()) {
			if (que.size() == 1) {// 방문할게 한 개가 남았다는 뜻은 하나의 토마토만 익으면 종료된다는 말임.
				day = que.peek().num;// 1이 한 개일 경우도 돌아가지만, 결국 마지막 하나 남았을때가 저장되게 되므로 상관 없음.
			}
			PositionT temp = que.poll();
			int tempI = temp.i;
			int tempJ = temp.j;
			int tempNum = temp.num;// 여기서 Num은 que에 들어갈 때 몇 일 지났는지를 확인하기 위한 값임.
			// 위에서 1에 해당되는 부분을 다 que에 넣을 때, num을 0일로 설정해놓았는데
			// que에서 나와서 근쳐에 있는 토마토를 방문할 때 +1을 해주는 건, 1일이 지났을때 얼마나 채워졌는지 효과를 주기 위함.
			if (tempI - 1 >= 0 && adjArr[tempI - 1][tempJ] == 0) {
				adjArr[tempI - 1][tempJ] = tempNum + 1;
				que.add(new PositionT(tempI - 1, tempJ, tempNum + 1));
				Visitcount++;
			}
			if (tempJ - 1 >= 0 && adjArr[tempI][tempJ - 1] == 0) {
				adjArr[tempI][tempJ - 1] = tempNum + 1;
				que.add(new PositionT(tempI, tempJ - 1, tempNum + 1));
				Visitcount++;
			}
			if (tempI + 1 < adjArr.length && adjArr[tempI + 1][tempJ] == 0) {
				adjArr[tempI + 1][tempJ] = tempNum + 1;
				que.add(new PositionT(tempI + 1, tempJ, tempNum + 1));
				Visitcount++;
			}
			if (tempJ + 1 < adjArr[0].length && adjArr[tempI][tempJ + 1] == 0) {
				adjArr[tempI][tempJ + 1] = tempNum + 1;
				que.add(new PositionT(tempI, tempJ + 1, tempNum + 1));
				Visitcount++;
			}
		}
		if (Visitcount != zeroCount) {// 방문횟수와 0의 횟수가 같다. 모든 사과가 익었다. 0으로 된 부분을 다 방문했다는 뜻.
			// 다르다는 말은 0으로 채워진 부분만큼 방문을 하지 않았다. 익을 수 없는 사과가 있다.
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}
}

class PositionT {
	int i;
	int j;
	int num;

	public PositionT(int i, int j, int num) {
		this.i = i;
		this.j = j;
		this.num = num;
	}
}
