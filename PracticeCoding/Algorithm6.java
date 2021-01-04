package PracticeCoding;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/60058?language=java

public class Algorithm6 {
	public static void main(String args[]) {
		solution6 s6 = new solution6();
		String s = "(()())()";
		s6.isBalanceOk(s);
		s = ")(";
		s6.isBalanceOk(s);
		s = "()))((()";
		s6.isBalanceOk(s);

		// s = "(()())()";
		// s6.devideUV(s);
		// s = ")(";
		// s6.devideUV(s);
		s = "()))((()";
		System.out.println(s6.devideUV(s));
		// s = "()";
		// s6.devideUV(s);
	}
}

class solution6 {
	public String solution(String p) {
		if(isBalanceOk(p)) {
			return p;
		}else {
			return devideUV(p);
		}
	}

	public boolean isBalanceOk(String p) {// 올바른 괄호문자열인지아닌지 확인.
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				stack.add('(' + "");
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public String devideUV(String p) {// u,v로 문자열 분열하면서 조금한 문제로 쪼개서 문제 해결. 
		if (p == "") {
			return "";
		}
		String u = "";
		String v = "";
		int left = 0;
		int right = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1, p.length());
				break;
			}
		}
		if (isBalanceOk(u)) {// 문자열 u가 올바른 괄호 문자열이 맞는 경우.
			return u + devideUV(v);
		} else {// 문자열 u가 올바른 괄호 문자열이 아닌 경우.
			return "(" + devideUV(v) + ")" + reverseOrder(u.substring(1, u.length()-1));
		}
	}

	public String reverseOrder(String p) {// '('와 ')'를 바꾸는 메소드.
		p = p.replace(")", "1");
		p = p.replace("(", "2");
		p = p.replace("1", "(");
		p = p.replace("2", ")");
		return p;
	}
}
