package Greedy;

import java.util.Scanner;

public class missedBracket {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String inputStr = input.next();
		String[] numArr = inputStr.replaceAll("-", ",-").replaceAll("\\+", ",").split(",");
		int sum = 0;
		boolean minus = false;
		for (int i = 0; i < numArr.length; i++) {
			if(Integer.parseInt(numArr[i]) >= 0 && minus == false) {
				sum += Integer.parseInt(numArr[i]);
			}else {
				minus = true;
				sum += -Math.abs(Integer.parseInt(numArr[i]));
			}
		}
		System.out.println(sum);
	}
}
