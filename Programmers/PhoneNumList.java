package Programmers;

public class PhoneNumList {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(solution(new String[] { "123", "456", "789" }));
		System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));

	}

	public static boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length - 1; i++) {
			String currentStr = phone_book[i];
			for(int j = i + 1 ; j < phone_book.length ; j++) {
				if(phone_book[j].startsWith(currentStr)) {
					return false;
				}
				else if(currentStr.startsWith(phone_book[j])) {
					return false;
				}
			}
		}
		return true;
	}
}
