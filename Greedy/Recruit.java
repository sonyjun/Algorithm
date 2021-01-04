package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Recruit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCaseNum; t++) {
			int memberNum = Integer.parseInt(br.readLine());
			int[] recruitRankArr = new int[memberNum + 1];
			for (int i = 0; i < recruitRankArr.length - 1; i++) {
				String[] str = br.readLine().split(" ");
				int test1 = Integer.parseInt(str[0]);
				int test2 = Integer.parseInt(str[1]);
				recruitRankArr[test1] = test2;
			}
			int passCount = 1;
			int rank = recruitRankArr[1];
			//1차 시험이 1등인 녀석은 무조건 합격.
			//다음 합격자는 1차시험 1등인 녀석보다 2차시험을 잘 쳐야됨
			//이에 해당되는 녀석이 나타난다면, 1차시험 1등인 녀석보다 2차시험을 
			//잘 친 녀석의 2차 시험 등수가 이제 또 합격의 컷트라인이 됨.
			//어차피 이녀석 다음에 살펴볼 애들은 이녀석보다 1차시험을 못본애들이니
			//기존 1등인 녀석보다 1차 시험은 당연히 못봤을거고 2차시험을 더 잘 본 친구가
			//새로운 컷트라인이 되는것이기 때문에.
			//이 문제의 핵심.
			//첫번째 합격자의 1차시험은 나머지 애들은 못이긴다. 2차 시험으로 승부봐야한다.
			//두번째 합격자의 1차시험은 나머지 애들은 못이긴다. 2차 시험으로 승부봐야한다.
			//즉 합격자 중에서 2차시험을 제일 잘 본 친구보다 잘 쳐야함.
			for (int i = 2; i <= memberNum; i++) {
				if(recruitRankArr[i] < rank) {
					passCount++;
					rank = recruitRankArr[i];
				}
			}
			System.out.println(passCount);
		}
	}
}
