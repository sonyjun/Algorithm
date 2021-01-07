package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertOper {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] numArr;
	static int[] operArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numArr = new int[n];
		operArr = new int[4];
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		operArr[0] = Integer.parseInt(st.nextToken());
		operArr[1] = Integer.parseInt(st.nextToken());
		operArr[2] = Integer.parseInt(st.nextToken());
		operArr[3] = Integer.parseInt(st.nextToken());
		DFS(0, numArr[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void DFS(int index, int sum) {// 현재 탐색 하는 인덱스와, 현재까지의 합
		// System.out.println("index : " + index + ", sum : " + sum);
		// return은 마지막 인덱스에 도착햇을 때.
		if (index == numArr.length - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {// 연산자 갯수만큼 돌아야지
			if (operArr[i] != 0) {
				switch (i) {
				case 0: {
					operArr[i]--;
					DFS(index + 1, sum + numArr[index + 1]);
					operArr[i]++;
					break;
				}
				case 1: {
					operArr[i]--;
					DFS(index + 1, sum - numArr[index + 1]);
					operArr[i]++;
					break;
				}
				case 2: {
					operArr[i]--;
					DFS(index + 1, sum * numArr[index + 1]);
					operArr[i]++;
					break;
				}
				case 3: {
					operArr[i]--;
					DFS(index + 1, sum / numArr[index + 1]);
					operArr[i]++;
					break;
				}
				}
			}
		}
	}
}
