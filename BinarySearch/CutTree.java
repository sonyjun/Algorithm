package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree {// 백준 랜선 자르기. 1654번
	static int[] treeHeightArr;
	static long totalMaxHeight = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		treeHeightArr = new int[n];
		long max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			treeHeightArr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, treeHeightArr[i]);
		}
		// 1~max를 범위로 해서 이분탐색 돌려야댐.
		search(max, m);
		System.out.println(totalMaxHeight);
	}

	private static long search(long maxLength, long target) {
		long begin = 1;
		long end = maxLength;

		while (begin <= end) {
			long mid = (begin + end) / 2;
			//System.out.println("start: " + begin + " , mid : " + mid + " , end :" + end);
			//System.out.println("mid의 계산값 : " + CalcLanCableNum(mid));
			if (CalcLanCableNum(mid) >= target) {//필요한 양보다 많거나 같은 경우. 같은 경우가 안 나올수도 있음.
				//System.out.println("1번");
				begin = mid + 1;
				if (totalMaxHeight < mid) {
					totalMaxHeight = mid;
				}
			} else {
				end = mid - 1;
			}
		}
		return end;
	}

	private static long CalcLanCableNum(long cutHeight) {
		long sumHeight = 0;
		for (int i = 0; i < treeHeightArr.length; i++) {
			if (treeHeightArr[i] > cutHeight) {
				sumHeight += treeHeightArr[i] - cutHeight;
			}
		}
		return sumHeight;
	}
}
