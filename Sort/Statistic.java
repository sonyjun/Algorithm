package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistic {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		double avgValue = 0;
		Arrays.sort(numArr);
		int[] countArr = new int[8001];
		for (int i = 0; i < n; i++) {
			avgValue += numArr[i];
			countArr[numArr[i] + 4000]++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round((double) avgValue / (double) n) + "\n");
		sb.append(numArr[n / 2] + "\n");

		int maxCount = -1;
		int maxValue = -1;
		for (int i = 0; i < numArr.length; i++) {
			if (countArr[numArr[i] + 4000] > maxCount) {
				maxCount = countArr[numArr[i] + 4000];// 최대 몇번 나오나 저장.
				maxValue = numArr[i];
			}
		}

		int count = 0;
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] == maxCount) {//만약 유일하게 크다면 count는 1이므로 그대로 최초에 찾았던 최대값으로 for문 종료
				count++;
				if (count == 2) {//같은 값이 또 나왔다면, 그 값이 출려되어야 함.
					sb.append((i - 4000) + "\n");
					break;
				}
			}
		}
		if (count == 1) {
			sb.append(maxValue + "\n");
		}
		if (n > 1) {
			if (numArr[0] < 0 && numArr[n - 1] < 0) {
				sb.append(Math.abs(numArr[n - 1] - numArr[0]) + "\n");
			} else {
				sb.append(numArr[n - 1] - numArr[0] + "\n");
			}
		} else {
			sb.append(0 + "\n");
		}
		System.out.println(sb);
	}
}
