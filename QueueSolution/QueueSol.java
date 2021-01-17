package QueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class QueueSol {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> que = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			if (instruction.equals("push")) {
				que.add(Integer.parseInt(st.nextToken()));
			}else if(instruction.equals("pop")) {
				if(que.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(que.poll()+"\n");
				}
			}else if(instruction.equals("size")) {
				sb.append(que.size()+"\n");
			}else if(instruction.equals("empty")) {
				if(que.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}else if(instruction.equals("front")) {
				if(que.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(que.peek()+"\n");
				}
			}else if(instruction.equals("back")) {
				if(que.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(que.getLast()+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
