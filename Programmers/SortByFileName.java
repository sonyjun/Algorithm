package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class SortByFileName {
	public static void main(String[] args) {
		solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });
		solution(new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" });
		// solution(new String[] { "F-15" });
	}

	public static String[] solution(String[] files) {
		ArrayList<MyFile> answerList = new ArrayList<MyFile>();
		for (int i = 0; i < files.length; i++) {
			files[i] = files[i];
			String[] temp = files[i].split("[a-z,A-Z,' ',\\.,\\-]+");
			String number = temp[1];
			// temp[1]은 NUMBER에 해당되는 부분.

			temp = files[i].split("[0-9]+");
			String head = temp[0];
			String tail = files[i].substring((head + number).length());
			/*
			 * System.out.println("head :" + head); System.out.println("number :" + number);
			 * System.out.println("tail :" + tail);
			 */
			answerList.add(new MyFile(head, number, tail));
		}
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i).head + answerList.get(i).number + answerList.get(i).tail;
		}
		return answer;
	}
}

class MyFile implements Comparable<MyFile> {
	String head;
	String number;
	String tail;

	public MyFile(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}

	@Override
	public int compareTo(MyFile o) {
		// TODO Auto-generated method stub
		String temp1 = head.toLowerCase();
		String temp2 = o.head.toLowerCase();
		if (temp1.compareTo(temp2) > 0) {
			return 1;
		} else if (temp1.compareTo(temp2) < 0) {
			return -1;
		} else {
			if (Integer.parseInt(number) - Integer.parseInt(o.number) > 0) {
				return 1;
			} else if (Integer.parseInt(number) - Integer.parseInt(o.number) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
