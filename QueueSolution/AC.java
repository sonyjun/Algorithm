package QueueSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String operStr = br.readLine();
			int numArrSize = Integer.parseInt(br.readLine());
			String numArrStr = br.readLine();
			numArrStr = numArrStr.replace("[", "").replace("]", "").replace(",", " ");//"[1,2,3] 이런 형태이기 때문에 "공백으로만 숫자가 구분되게 만들어줌.
			StringTokenizer st = new StringTokenizer(numArrStr);//공백으로 구분
			Deque<Integer> deque = new ArrayDeque<Integer>();
			for (int j = 0; j < numArrSize; j++) {
				deque.add(Integer.parseInt(st.nextToken()));// 데큐에 값을 다 넣어줌.
			}
			boolean isHead = true;// 입구가 어디다 표시하기 위한 변수  true : first , false : last
			boolean isError = false;
			for (int j = 0; j < operStr.length(); j++) {
				if (operStr.charAt(j) == 'R') {
					if (isHead == true) {
						isHead = false;
					} else {
						isHead = true;
					}
				} else if (operStr.charAt(j) == 'D') {
					if (!deque.isEmpty()) {
						if (isHead == true) {// 입구가 어딘지에 따라 맞추어 poll수행.
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
					}else {// que가 비어있는데 빼려고 하면 에러임.
						isError = true;
						break;
					}
				}
			}
			if(isError == true) {//에러라면 에러라 출력하고 끝.
				sb.append("error\n");
			}else {//에러아니면 큐에 남은 값들 출력 해주어야 함.
				sb.append("[");
				while(deque.size() > 1) {// 출력 형식이 정해져 있으므로 마지막 값을 제외하고 출력
					if(isHead == true) {
						sb.append(deque.pollFirst()+",");
					}else {
						sb.append(deque.pollLast()+",");
					}
				}

				if(isHead == true && !deque.isEmpty()) {//입구에 맞추어 출력
					sb.append(deque.pollFirst()+"]\n");
				}else if(isHead == false && !deque.isEmpty()){
					sb.append(deque.pollLast()+"]\n");
				}else {//만약 큐에 아무것도 없을 경우엔 빈 것을 출력, 예를 들어 연산 D와 [1]이 주어지면 []가 되게 출력해야함.
					sb.append("]\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}
/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
*/