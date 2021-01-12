package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSol {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			if (str.length > 1) {
				stack.add(Integer.parseInt(str[1]));
			} else {
				if (str[0].equals("top")) {
					if(stack.isEmpty()) {
						sb.append(-1+"\n");
					}else {
						sb.append(stack.peek()+"\n");
					}
				} else if (str[0].equals("size")) {
					sb.append(stack.size()+"\n");
				} else if (str[0].equals("empty")) {
					if(stack.isEmpty()) {
						sb.append(1+"\n");
					}else {
						sb.append(0+"\n");
					}
				} else if (str[0].equals("pop")) {
					if(stack.isEmpty()) {
						sb.append(-1+"\n");
					}else {
						sb.append(stack.pop()+"\n");
					}
				}
			}
		}
		System.out.println(sb);
	}
}
