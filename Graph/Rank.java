package Graph;

import java.util.HashSet;

public class Rank {
	public static void main(String args[]) {
		RankSolution r = new RankSolution();
		r.solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } });
	}
}

class RankSolution {
	public int solution(int n, int[][] results) {
		int[] count = new int[n];
		for (int i = 0; i < results.length; i++) {
			count[results[i][0]-1]++;
			count[results[i][1]-1]++;
			if(count[i] == n-1) {
				
			}
		}
		for(int i : count) {
			System.out.print(i+" ");
		}
		int answer = 0;
		return answer;
	}
}
