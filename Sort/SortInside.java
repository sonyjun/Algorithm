package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SortInside {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Integer[] numArr = new Integer[str.length()];
		for (int i = 0; i < str.length(); i++) {
			numArr[i] = Integer.parseInt(str.charAt(i) + "");
		}
		Arrays.sort(numArr, Collections.reverseOrder());
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
	}
}
