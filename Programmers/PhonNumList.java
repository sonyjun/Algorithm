package Programmers;

import java.util.Arrays;

public class PhonNumList {
	public static void main(String args[]) {
		PhonNumListSolution p = new PhonNumListSolution();
		p.solution(new String[] { "12", "123", "1235", "567", "88" });
	}
}

class PhonNumListSolution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);
		for(String s : phone_book) {
			System.out.print(s+"  ");
		}
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
		return answer;
	}
}