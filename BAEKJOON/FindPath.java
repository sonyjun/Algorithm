package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FindPath {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] adjArr = new int[n][n];
		for (int i = 0; i < adjArr.length; i++) {
			for (int j = 0; j < adjArr.length; j++) {
				adjArr[i][j] = input.nextInt();
			}
		}
		int[][] answer= new int[n][n];
		boolean[] visited = new boolean[adjArr.length];
		for (int i = 0; i < adjArr.length; i++) {
			DFS(i,adjArr,visited);
			for(int j = 0; j < visited.length ; j++) {
				if(visited[j] == true) {
					answer[i][j] = 1;
					System.out.print(1+" ");
				}else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
			Arrays.fill(visited, false);
		}
	}

	// 어느 한 정점을 시작점으로 해서 DFS를 수행하면
	public static void DFS(int startVertex, int[][] adjArr, boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//단방향성이기 때문에 처음 정점은 방문햇다고 체크 x, 되돌아오는게 있으면 
		for (int i = 0; i < adjArr.length; i++) {
			if (adjArr[startVertex][i] == 1) {
				stack.add(i);
			}
		}
		while (!stack.isEmpty()) {
			int popVertex = stack.pop();
			if (visited[popVertex] == false) {
				visited[popVertex] = true;
				for (int i = 0; i < adjArr.length; i++) {
					if (adjArr[popVertex][i] == 1) {
						stack.add(i);
					}
				}
			}
		}
	}
}
