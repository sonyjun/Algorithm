package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//고찰 : 이 전값의 최소값을 이용해 새로운 값을 구한다. 이건 DP에 적합한 알고리즘.
//      현재 값으로 최선의 선택을 한다. 이건 그리디 알고리즘임..
//두 방법은 접근 방식 자체가 다르므로 다른 결과를 낼 수 밖에 없다. 
//아래 테스트케이스처럼 DP는 이번에 빨간색을 칠 할건데 전의 최소값에 이 값을 더해주면 되고,
//그리디라면 그냥 그 순간에 선택임. 
//i번째 칠할때 나올 수 있는 제일 작은 값이 나오게 한다(DP)
//i번째 칠할때 제일 작은 비용의 페인트로 칠한다(그리디)

/*
3
1 20 30
50 5 6
9 3 7
 */
public class RGB_Road {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] dp = new int[num][3];
		int[] prevArr = new int[3];
		int[][] houseCostArr = new int[num][3];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			houseCostArr[i][0] = Integer.parseInt(st.nextToken());
			houseCostArr[i][1] = Integer.parseInt(st.nextToken());
			houseCostArr[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = houseCostArr[0][0];
		dp[0][1] = houseCostArr[0][1];
		dp[0][2] = houseCostArr[0][2];
		prevArr[0] = 0;
		prevArr[1] = 1;
		prevArr[2] = 2;
		for (int i = 0; i < num - 1; i++) {// 한 행을 나타냄
			for (int j = 0; j < 3; j++) {// 한 행의 하나의 값을 나타냄
				if (prevArr[j] == 0) {
					if (houseCostArr[i + 1][1] < houseCostArr[i + 1][2]) {
						prevArr[j] = 1;
					} else {
						prevArr[j] = 2;
					}
					dp[i + 1][j] = dp[i][j] + Math.min(houseCostArr[i + 1][1], houseCostArr[i + 1][2]);
				} else if (prevArr[j] == 1) {
					if (houseCostArr[i + 1][0] < houseCostArr[i + 1][2]) {
						prevArr[j] = 0;
					} else {
						prevArr[j] = 2;
					}
					dp[i + 1][j] = dp[i][j] + Math.min(houseCostArr[i + 1][0], houseCostArr[i + 1][2]);
				} else if (prevArr[j] == 2) {
					if (houseCostArr[i + 1][0] < houseCostArr[i + 1][1]) {
						prevArr[j] = 0;
					} else {
						prevArr[j] = 1;
					}
					dp[i + 1][j] = dp[i][j] + Math.min(houseCostArr[i + 1][0], houseCostArr[i + 1][1]);
				}
			}
		}
		int min = 1000 * num + 1;
		for (int i = 0; i < 3; i++) {
			if (min > dp[num - 1][i]) {
				min = dp[num - 1][i];
			}
		}
		System.out.println(min);
	}
}
/*
3
1 10 10
1 10 10
1 10 10
 */


