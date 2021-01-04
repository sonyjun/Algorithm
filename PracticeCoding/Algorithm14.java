package PracticeCoding;

import java.util.LinkedList;

public class Algorithm14 {
	public static void main(String args[]) {
		Solution14 s14 = new Solution14();
		int n = 9;
		int[][] edges = { { 0, 2 }, { 2, 1 }, { 2, 4 }, { 3, 5 }, { 5, 4 }, { 5, 7 }, { 7, 6 }, { 6, 8 } };
		s14.solution(n, edges);
	}
}

class Solution14 {
	public int[] solution(int n, int[][] edges) {
		int[][] adjArr = new int[n][n];// 인접리스트 배열
		int[] adjCount = new int[n];// 각 노드별 인접 갯수.
		int[] setCount = new int[n];// 각 노드별 인접 갯수.
		int[] endCount;
		int atleastNum = n/3 -1;
		for (int i = 0; i < edges.length; i++) {
			adjArr[edges[i][0]][edges[i][1]] = 1;
			adjArr[edges[i][1]][edges[i][0]] = 1;
		}
		for (int i = 0; i < adjArr.length; i++) { // 노드별 인접 갯수 계산.
			for (int j = 0; j < adjArr.length; j++) {
				if (adjArr[i][j] == 1) {
					adjCount[i] += 1;
				}
			}
		}
		for (int i = 0; i < adjArr.length; i++) {
			if (adjCount[i] == 1) {
				adjCount[i]--;
				setCount[i]--;
				for (int j = 0; j < adjArr.length; j++) {
					if (adjArr[i][j] == 1) {
						setCount[j]++;
						adjArr[i][j] = 0;
						adjArr[j][i] = 0;
					}

				}
			}
		}
		int sum = 0 ;
		for (int i = 0; i < setCount.length; i++) {
			System.out.print(setCount[i]+" ");
			if(setCount[i] > 0) {
				sum += setCount[i];
			}else if(setCount[i] == 0) {
				sum += 1;
			}
			if(sum == atleastNum) {
				System.out.println();
			}
		}
		System.out.println("");
		
		for (int i = setCount.length-1 ; i >= 0; i--) {
			System.out.print(setCount[i]+" ");
		}
		System.out.println("");
		/*
		endCount = new int[10];
		int count= 0 ;
		for (int i = 0; i < adjCount.length; i++) {
			adjCount[i] = adjCount[i]-setCount[i];
			if(adjCount[i] != 0) {
				endCount[count++] = adjCount[i];
			}
		}
		*/
		/*
		System.out.println("");
		for (int i = 0; i < endCount.length; i++) {
			System.out.print(endCount[i]+" ");
		}*/
/*		for (int i = 0; i < adjCount.length; i++) {
			System.out.print(adjCount[i]+" ");
		}*/
		/*
		for (int i = 0; i < adjArr.length; i++) {
			for (int j = 0; j < adjArr.length; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println("");
		}*/
		
		int[] answer = {};
		return answer;
	}

}
