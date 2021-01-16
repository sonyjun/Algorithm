package StackSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BiggestRightNum {
	//문제의 핵심은 오른쪽부터 시작해서 자기보다 작은 녀석은 이제 더 이상 비교할 필요 없이 재껴주는 역할을 스택이 해줌 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		int[] answer = new int[n];
		int index = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			leftStack.push(Integer.parseInt(st.nextToken()));
		}
		while (!leftStack.isEmpty()) {
			int leftPopNum = leftStack.pop();
			boolean isConsist = false;
			while (!rightStack.isEmpty()) {// 오른쪽 스택 비어있지 않다면,
				int rightPeekNum = rightStack.peek();
				if (leftPopNum >= rightPeekNum) {// 나보다 작다면 비교 가치 없으니 버려
					rightStack.pop();
				} else if(leftPopNum < rightPeekNum){// 나보다 크면 그 친구가 내 오른쪽에서 가장 가까운 큰 수임.
					answer[index++] = rightPeekNum;
					rightStack.push(leftPopNum);
					isConsist = true;
					break;
				}
			}

			if (isConsist == false) {//자기보다 큰 녀석이 없을경우 여기 걸림. 다시 오른쪽 스택에 들어가야 비교대상이 되지.
				answer[index++] = -1;
				rightStack.add(leftPopNum);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = answer.length - 1; i >= 0; i--) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}
}
