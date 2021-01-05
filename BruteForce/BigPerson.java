package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BigPerson {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int personNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] personArr = new int[personNum][2];
		int[] rankArr = new int[personNum];
		for (int i = 0; i < personNum; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			personArr[i][0] = weight;
			personArr[i][1] = height;
		}
		/*Arrays.sort(personArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] > o2[0]) {
					return 1;
				} else {
					return -1;
				}
			}

		});*/
		for (int i = 0; i < personNum; i++) {
			int rank = 1;
			for (int j = 0; j < personNum; j++) {
				if (personArr[i][0] < personArr[j][0] && personArr[i][1] < personArr[j][1]) {
					rank++;
				}
			}
			rankArr[i] = rank;
		}
		for (int i = 0; i < personNum; i++) {
			//System.out.println(personArr[i][0] + ", " + personArr[i][1]);
			System.out.print(rankArr[i]+" ");
		}
	}
}
