package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Boolean> stack = new Stack<Boolean>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			stack = new Stack<Boolean>();
			String str = br.readLine();
			boolean isCollect = true;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.add(true);
				}else {
					if(!stack.isEmpty()) {
						stack.pop();
					}else {
						isCollect = false;
						break;
					}
				}
			}
			if(stack.isEmpty() && isCollect == true) {
				sb.append("YES\n");
			}else{
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
