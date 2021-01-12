package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] distanceArr = new int[n - 1];
		int[] gasCostArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			distanceArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			gasCostArr[i] = Integer.parseInt(st.nextToken());
		}
//		for (int i = 0; i < n - 1; i++) {
//			System.out.print(distanceArr[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.print(gasCostArr[i] + " ");
//		}
//		System.out.println();

		long sumPay = 0;
		for (int i = 0; i < gasCostArr.length - 1;) {
			long currentGasCost = gasCostArr[i];
			long distance = distanceArr[i];
			for (int j = i + 1; j < gasCostArr.length; j++) {
				if (currentGasCost >= gasCostArr[j]) {
					i = j;
					break;
				} else {
					if(j >= distanceArr.length) {
						i = j;
						break;
					}else {
						distance += distanceArr[j];
					}
				}
			}
			sumPay += distance * currentGasCost;
//			System.out.println("currentGas : "+ currentGasCost);
//			System.out.println("distance : "+ distance);
		}
		System.out.println(sumPay);
	}
}
