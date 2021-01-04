package Greedy;

import java.util.Arrays;

public class CheckCamera {
	public static void main(String args[]) {
		CheckCameraSolution c = new CheckCameraSolution();
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(c.solution(routes));;
	}
}

class CheckCameraSolution {
	public int solution(int[][] routes) {

        // 끝나는 시간 순 대로 오름차순 정렬
		Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1]));
		// routes[i][1] 값을 기준으로 정렬. 활용하자!!.
		
		int cnt = 0;
		
		int min = Integer.MIN_VALUE;
		for(int[] route : routes) {
			if(min <  route[0] ) {
				// 전 거의 끝나는 시간 보다 시작 시간이 큰 경우
				// 안 겹치니까 변경하고, 숫자 더하기
				min = route[1];
				++cnt;
			}
		}
        return cnt;
	}
}