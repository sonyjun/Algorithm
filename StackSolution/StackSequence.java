package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] inputNum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			inputNum[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int lastIndex = 0;
		for (int i = 1; i <= n; i++) {
			int count = inputNum[i] - lastIndex;
			if (lastIndex < inputNum[i]) {//만약 스택에 마지막에 들어간 숫자보다 비교되는 숫자가 더 크다면, push로 더 넣어줘야지. 원하는 숫자 무조건 나옴,
				for (int j = 0; j < count; j++) {//차이나는 숫자만큼 넣어줌.
					stack.add(++lastIndex);
					sb.append("+\n");
				}
				stack.pop();//그 만큼 넣어주면 비교되는 숫자가 스택에서 제일 위에 있을거니 그 값을 빼준다.
				sb.append("-\n");
			} else {
				//만약 마지막에 들어간 스택 숫자보다 작다면,스택 안에 있는 상태이다. pop을 해봐서 내가 비교하려는 숫자와 같아야 만들수 있는 수열이 되는 것임.
				int popNum = stack.pop();
				sb.append("-\n");
				if (popNum != inputNum[i]) {
					System.out.println("NO");
					System.exit(0);
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
