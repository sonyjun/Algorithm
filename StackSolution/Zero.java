package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < n ; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				stack.pop();
			}else {
				stack.add(input);
			}
		}
		int sum = 0; 
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
