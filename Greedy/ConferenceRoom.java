package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConferenceRoom {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] meetingArr = new int[num][2];
		for (int i = 0; i < meetingArr.length; i++) {
			meetingArr[i][0] = input.nextInt();
			meetingArr[i][1] = input.nextInt();
		}
		Arrays.sort(meetingArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}

		});
		int finishTime = 0;
		int count = 1;
		finishTime = meetingArr[0][1];
		for (int j = 1; j < meetingArr.length; j++) {
			//System.out.println(j);
			if (finishTime <= meetingArr[j][0]) {
				finishTime = meetingArr[j][1];
				count++;
			}
		}
		System.out.println(count);
		/*for (int i = 0; i < meetingArr.length; i++) {
			System.out.print(meetingArr[i][0] + " ");
			System.out.print(meetingArr[i][1]);
			System.out.println();
		}*/
	}
}
