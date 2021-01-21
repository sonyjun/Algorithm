package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallModem {
	static int[] housePositionArr;
	static long maxDistance = 0;
	static int houseNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		houseNum = Integer.parseInt(st.nextToken());
		int ModemNum = Integer.parseInt(st.nextToken());
		housePositionArr = new int[houseNum];
		long max = 0;
		for (int i = 0; i < houseNum; i++) {
			housePositionArr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(housePositionArr);
		max = housePositionArr[houseNum - 1] - housePositionArr[0];
		// 1~max를 범위로 해서 이분탐색 돌려야댐.
		search(max, ModemNum);
		System.out.println(maxDistance);
	}

	private static long search(long max, long target) {
		long begin = 1;
		long end = max;

		while (begin <= end) {
			long mid = (begin + end) / 2;// mid가 가장 인접한 집 사이의 거리. (이거보다 크거나 같아야 설치 가능)

			int count = 1;// 첫번째 집에 설치되었다고 가정.
			int start = housePositionArr[0];// 마지막으로 공유기가 설치된 곳의 position
			for (int i = 1; i < houseNum; i++) {
				if (housePositionArr[i] - start >= mid) {
					count++;// 설치 가능하므로 갯수 올려줌.
					start = housePositionArr[i];
				}
			}
			
			if (count >= target) {
				// 만약 설치한 공유기의 갯수가 보유량 보다 같거나 많다면,, 설치한 공유기 갯수가 보유량보다 많아도 되는걸 받아들이는 이유는 결국 갯수가
				// 보유량에 가까워 질수록 최대값이 나올 것이다. 그때는 결국 보유량을 모두 썼을 때이므로, 해당 보유량을 딱 썻을 때 최대 mid의 갯수를 받으면 되는 것이다.
				maxDistance = mid;
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}
}
