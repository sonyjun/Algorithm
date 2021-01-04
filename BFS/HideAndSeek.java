package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	public static void main(String arsg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subinPos = Integer.parseInt(st.nextToken());
		int brotherPos = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		//1개의 숫자가 3개가 되고 3^n 번의 계산과정을 하다보면 똑같은 숫자를 다루는 경우가 있으므로, 중복되어 넣지 않게 방문 배열생성.
		System.out.println(BFS(subinPos, brotherPos, visited));
	}

	public static int BFS(int subinPos, int brotherPos, boolean[] visited) {
		Queue<TimeElement> que = new LinkedList<TimeElement>();
		que.add(new TimeElement(subinPos, 0));
		visited[subinPos] = true;
		int minTime = 100000;
		while (!que.isEmpty()) {
			//que에는 모든 경우의 수가 다 들어감. 수빈 위치 +1 or -1 or *2 일때.
			TimeElement temp = que.poll();
			//만약 나온 결과의 위치가 동생의 위치와 같다면 return
			if (temp.position == brotherPos) {
				minTime = temp.time;
				break;
			} else {
				int case1pos = temp.position - 1;
				int case2pos = temp.position + 1;
				int case3pos = temp.position * 2;
				System.out.println(case1pos + "," + case2pos + "," + case3pos);
				
				// -1을 계속 해줄 경우 음수로 이동하는 건 쓸데없는 짓이므로.
				//하지만 0의 위치는 가능하고 que에 넣고 나올때 정답 검사를 하므로 0보다 크거나 같음으로 두었음.
				if (case1pos >= 0 && visited[case1pos] == false) {
					visited[case1pos] = true;
					que.add(new TimeElement(case1pos, temp.time + 1));
				}
				//+1을 하는 작업은 동생의 위치를 넘어가서 하는 경우는 의미가 없음.
				//왜냐 2배로 이동하는 경우는 되돌아 오는 경우(즉, 나누기 2에 해당)는 불가능하기 때문이다.
				if (case2pos <= brotherPos && case2pos < 100001 && visited[case2pos] == false) {
					visited[case2pos] = true;
					que.add(new TimeElement(case2pos, temp.time + 1));
				}
				//여기서는 동생의 위치를 넘고 -1 작업을 하여 도달할 수 있으므로 동생의 위치보다 작다는 조건문은 생략되었다.
				if (case3pos < 100001 && visited[case3pos] == false) {
					visited[case3pos] = true;
					que.add(new TimeElement(case3pos, temp.time + 1));
				}

			}

		}
		return minTime;
	}
}

class TimeElement {
	int time;
	int position;

	public TimeElement(int position, int time) {
		this.time = time;
		this.position = position;
	}
}