package PracticeCoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Algorithm5 {
	public static void main(String args[]) {
		Solution5 s5 = new Solution5();
		String s = "aabbaccc";
		System.out.println(s5.solution1(s));
		s = "ababcdcdababcdcd";
		System.out.println(s5.solution1(s));
		s = "abcabcdede";
		System.out.println(s5.solution1(s));
		s = "abcabcabcabcdededededede";
		System.out.println(s5.solution1(s));
		s = "xababcdcdababcdcd";
		System.out.println(s5.solution1(s));
		s = "AABAAAAAAABBB";
		System.out.println(s5.solution1(s));//11
		s = "BBBAAB";
		System.out.println(s5.solution1(s));//9

	}
}

class Solution5 {
	
	public int solution(String s) {
		int min = Integer.MAX_VALUE;
		String[] stringArr;
		int index = 0;
		int count = 1;
		String answerStr = "";
		for (int i = 1; i <= (s.length() / 2)+1 ; i++) {
			stringArr = new String[s.length()];
			index = 0;
			for (int j = 0; j < s.length(); j = j + i) {
				if (j + i <= s.length()) {
					stringArr[index++] = s.substring(j, j + i);
				}else {
					stringArr[index++] = s.substring(j,s.length());
				}
			}

			System.out.println("i: " + i);
			for (int j = 0; j < index; j++) {
				System.out.print(stringArr[j] + " ");
			}
			System.out.println();
			
			for (int j = 0; j < index - 1; j++) {
				if (stringArr[j].equals(stringArr[j + 1])) {
					count++;
				} else {
					if (count > 1) {
						answerStr += count + stringArr[j];
					} else {
						answerStr += stringArr[j];
					}
					count = 1;
				}

				if (j == index - 2) {
					if (count > 1) {
						answerStr += count + stringArr[j];
					} else {
						answerStr += stringArr[j+1];
					}
					count = 1;
				}
				
			}
			if (answerStr.length() < min) {
				min = answerStr.length();
			}
			answerStr = "";
		}

		return min;
	}
	
	public int solution1(String s) {
		int min = Integer.MAX_VALUE;
		String answerStr = "";
		String temp="";
		String before="";
		int count;
		for (int i = 1; i <= (s.length() / 2) + 1 ; i++) {//몇개의 문자열로 나눌지 1부터 차례로.
			count = 1;
			before="";
			for (int j = 0; j < s.length(); j = j + i) {
				if (j + i <= s.length()) {// temp에 문자열 하나하나씩 넣음.
					temp = s.substring(j, j + i);//인덱스 범위에서의 처리
				}else {
					temp = s.substring(j,s.length());//인덱스 넘어갈때 나머지 다 때려넣음.
				}

				//System.out.println("temp: "+temp);
				if(before.equals(temp)) { // 만약 전 문자열과 현재 문자열 같다면,
					count++;
				}else {// 만약 전 문자열과 현재 문자열이 다르다면, 출력이 필요함.
					if (count != 1) {// count가 1이 아닌경우 연속하는게 존재, 숫자를 처리하는 구문.
						answerStr += count;
					}
					answerStr += before;
					before = temp; // before값을 현재 문자열을 넣어 다음차례에 이용될수 있도록,
					count = 1;
				}
			}
			if(count != 1) {//마지막 문자열은 처리가 안되니까 따로 처리해줌. 갯수를 붙여주는 작업
				answerStr += count;
			}
			answerStr += before;//결국 마지막 턴에서 같은 문자열이 나오던, 다른 문자열이 나오던 출력이 안됨.
			//System.out.println("answer: "+ answerStr);
			if (answerStr.length() < min) {
				min = answerStr.length();
			}
			answerStr = "";
		}
		return min;
	}
}
