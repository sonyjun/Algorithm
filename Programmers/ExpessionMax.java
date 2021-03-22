package Programmers;

import java.util.ArrayList;

public class ExpessionMax {
	static String[] oper = { "-", "+", "*" };
	static final int minus = 0;
	static final int plus = 1;
	static final int mul = 2;
	static int[][] order = new int[6][3];
	static int index = 0;

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));

	}

	public static long solution(String expression) {
		index = 0;
		int n = 3;
		int[] arr = { 0, 1, 2 };
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		perm(arr, output, visited, 0, n, 3);

		String[] splitOper = expression.split("[0-9]+");
		String[] splitNum = expression.split("\\-|\\*|\\+");

		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add(splitNum[0]);
		for (int i = 1; i < splitNum.length; i++) {
			// System.out.println(splitOper[i].replaceAll(" ", ""));
			arraylist.add(splitOper[i].replaceAll(" ", ""));
			arraylist.add(splitNum[i]);
		}
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < order.length; i++) {// order 배열 (6가지 경우의 수 가르킴)
			ArrayList<String> templist = (ArrayList<String>) arraylist.clone();
			for (int j = 0; j < 3; j++) {// 각 행의 3가지 순열을 가르킴
				String operStr = oper[order[i][j]];// 여기서 다음 연산자가 결정됨.
				for (int t = 0; t < templist.size(); t++) {
					if (operStr.equals(templist.get(t))) {
						long result = 0;
						if (operStr.equals("-")) {
							result = Long.parseLong(templist.get(t - 1)) - Long.parseLong(templist.get(t + 1));
						} else if (operStr.equals("+")) {
							result = Long.parseLong(templist.get(t - 1)) + Long.parseLong(templist.get(t + 1));
						} else if (operStr.equals("*")) {
							result = Long.parseLong(templist.get(t - 1)) * Long.parseLong(templist.get(t + 1));
						}
						templist.add(t - 1, result + "");
						templist.remove(t);
						templist.remove(t);
						templist.remove(t);
						t--;
					}
				}
			}
			max = Math.max(max, Math.abs(Long.parseLong(templist.get(0))));
		}
		return max;
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < output.length; i++) {
				order[index][i] = output[i];
			}
			index++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

}
