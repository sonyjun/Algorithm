package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ApartNumber {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public static void main(String args[]) throws Exception {
		int num = Integer.parseInt(br.readLine());
		int[][] adjArr = new int[num][num];
		for (int i = 0; i < num; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < num; j++) {
				adjArr[i][j] = Integer.parseInt(inputStr.charAt(j) + "");
				// System.out.println(inputStr.charAt(j) +" ");
			}
		}

		int apartNum = 2;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (adjArr[i][j] == 1) {
					BFS(adjArr, i, j, apartNum);
					apartNum++;
				}
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}
		Collections.sort(arrayList);
		System.out.println(arrayList.size());
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}

	public static void BFS(int[][] adjArr, int i, int j, int apartNum) {
		int count = 1;
		adjArr[i][j] = apartNum;
		Queue<Position> que = new LinkedList<Position>();
		que.add(new Position(i, j));
		while (!que.isEmpty()) {
			Position temp = que.poll();
			int tempI = temp.i;
			int tempJ = temp.j;
			if (tempI - 1 >= 0 && adjArr[tempI - 1][tempJ] == 1) {
				adjArr[tempI - 1][tempJ] = apartNum;
				que.add(new Position(tempI - 1, tempJ));
				count++;
			}
			if (tempJ - 1 >= 0 && adjArr[tempI][tempJ - 1] == 1) {
				adjArr[tempI][tempJ - 1] = apartNum;
				que.add(new Position(tempI, tempJ - 1));
				count++;
			}
			if (tempI + 1 < adjArr.length && adjArr[tempI + 1][tempJ] == 1) {
				adjArr[tempI + 1][tempJ] = apartNum;
				que.add(new Position(tempI + 1, tempJ));
				count++;
			}
			if (tempJ + 1 < adjArr.length && adjArr[tempI][tempJ + 1] == 1) {
				adjArr[tempI][tempJ + 1] = apartNum;
				que.add(new Position(tempI, tempJ + 1));
				count++;
			}
		}
		arrayList.add(count);
	}
}

class Position {
	int i;
	int j;

	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
