package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BlancedWorld {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack;
		StringBuilder sb = new StringBuilder();
		// ( : 0
		// [ : 1
		while (true) {
			String str = br.readLine();
			if (str.charAt(0) == '.') {
				break;
			} else {
				stack = new Stack<Integer>();
				boolean isCollect = true;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						stack.add(0);
					} else if (str.charAt(i) == '[') {
						stack.add(1);
					} else if (str.charAt(i) == ')') {
						if(!stack.isEmpty() && stack.peek() == 0) {
							stack.pop();
						}else {
							isCollect = false;
							break;
						}
					} else if (str.charAt(i) == ']') {
						if(!stack.isEmpty() && stack.peek() == 1) {
							stack.pop();
						}else{
							isCollect = false;
							break;
						}
					}
				}
				if(stack.isEmpty() && isCollect == true) {
					sb.append("yes\n");
				}else {
					sb.append("no\n");
				}
			}
		}
		System.out.println(sb);
	}
}
