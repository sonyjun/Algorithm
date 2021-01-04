package Greedy;

import java.util.Scanner;

public class SugarDelivery {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int inputNum = input.nextInt();
		int count = 0;
		while(true) {
			if((inputNum % 5) == 0) {
				System.out.println(inputNum/5 + count);
				break;
			}else if(inputNum <= 0){
				System.out.println(-1);
				break;
			}
			inputNum -= 3;
			count++;
		}
		/*
		int bongjiNum = (inputNum / 5); // 5kg짜리로 다 채운다.
		int temp = inputNum % 5; // 5kg로 채우고 나머지.

		if (temp == 1) {
			if (bongjiNum >= 1) {
				bongjiNum++;
			}else {
				bongjiNum = -1;
			}
		} else if (temp == 2) {
			if (bongjiNum >= 2) {
				bongjiNum += 2;
			}else {
				bongjiNum = -1;
			}
		} else if (temp == 3) {
			bongjiNum++;
		} else if (temp == 4) {
			if (bongjiNum >= 1) {
				bongjiNum += 2;
			}else {
				bongjiNum = -1;
			}
		}
		System.out.println(bongjiNum);*/
	}
}
