package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSequence2 {
	// lowerbound를 이용한다.
	// lowerbound는 (정렬을 헤치지 않는 선에서)특정 값이 들어갈 수 있는 최소 인덱스를 말함.
	// 1 4 5 6 배열에서 3의 lowerbound는 4의 위치인 2번 인덱스이다.
	// 1 3 5 6 이 되어도 정렬은 유지가 된다는 뜻.
	// 결국 증가하는 수열의 갯수에는 영향을 미치지 않는다. 최종 원소는 다를 수 있음
	// 실제 원소를 알고 싶으면, 해당 원소의 위치값을 기억 시켜놓고 오른쪽부터 왼쪽 방향으로 순서대로 출력 
	// ex) 3자리수의 부분집합이라면 3에 해당되는 값 출력 그 다음 2에 해당되는 값 그 다음 1에 해당되는 값.

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sequenceNum = Integer.parseInt(br.readLine());
		int[] sequenceArr = new int[sequenceNum + 1];
		int[] lis = new int[sequenceNum + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < sequenceNum + 1; i++) {
			sequenceArr[i] = Integer.parseInt(st.nextToken());
		}

		lis[1] = sequenceArr[1];
		int lastIndex = 1;
		for (int i = 2; i < lis.length; i++) {
			if (lis[lastIndex] < sequenceArr[i]) {
				lis[++lastIndex] = sequenceArr[i];
				//System.out.println("여기1");
			} else {
				int lowerIndex = lowerBound(lis, lastIndex, sequenceArr[i]);
				lis[lowerIndex] = sequenceArr[i];
				//System.out.println("여기2 : " + lowerIndex);
			}

		}
		System.out.println(lastIndex);
	}

	private static int lowerBound(int[] data, int size, int target) {
		int begin = 1;
		int end = size;

		while (begin < end) {
			int mid = (begin + end) / 2;

			if (data[mid] >= target) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return end;
	}
}
