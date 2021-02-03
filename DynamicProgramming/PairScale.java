package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PairScale {// 백준 양팔저울. 2629번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weightNum = Integer.parseInt(br.readLine());
		int[] weightArr = new int[weightNum+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= weightNum; i++) {
			weightArr[i] = Integer.parseInt(st.nextToken());
		}
		int beadNum = Integer.parseInt(br.readLine());
		int[] beadArr = new int[beadNum+1];
		 st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= beadNum; i++) {
			beadArr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[][] dp = new boolean[weightNum + 1][40001];
		int sum = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i][weightArr[i]] = true;//i번째 추에 해당되는 무게를 고려할 때, 일단 본인 무게 가능하다고 체크.
			
			for (int j = 1; j <= sum; j++) {
				// sum은 i-1번째까지 합한 추의 무게. 만들 수 있는 최대 무게와 같음.
				// i번째를 고려하지 않은 i-1번째 행에서 만들 수 있던 무게(인덱스)까지만 루프 돌아도 되므로 설정해놓은 것.
				
				// i-1번째에 만들 수 있었던 무게들에서 더하거나 빼서 만들 수 있는 숫자 체크.
				if(dp[i-1][j] == true) {// j라는 무게를 만들 수 있다면, j에 i번째 추의 무게를 더하거나 빼서
										// 만들 수 있는 숫자를 체크해줌.
					dp[i][j] = true;
					dp[i][Math.abs(weightArr[i]-j)] = true;
					dp[i][weightArr[i]+j] = true;
				}	 
			}
			sum += weightArr[i];
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1 ; i < beadArr.length ; i++) {
			if(dp[weightNum][beadArr[i]] == true) {
				bw.write("Y ");
			}else {
				bw.write("N ");
			}
		}
		/*for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		bw.close();
		
		
	}
}
