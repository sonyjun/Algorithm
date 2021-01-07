package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CoordinateSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			field[i][0] = x;
			field[i][1] = y;
		}
		Arrays.sort(field, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(field[i][0] + " " + field[i][1]+"\n");
		}
		System.out.println(sb);
	}
}
