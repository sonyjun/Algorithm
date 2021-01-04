package Greedy;

public class JoyStick {
	public static void main(String args[]) {
		// 65(A)~90(Z) 알파벳
		JoyStickSolution j = new JoyStickSolution();
		// System.out.println(j.solution("AAABAAAAAABBB"));
		// System.out.println(j.solution("JEROEN") + " !!!");
		System.out.println(j.solution("BBBAAAB") + " !!!");
	}
}

class JoyStickSolution {

	public int solution(String name) {
		boolean[] visited = new boolean[name.length()];
		int count = 0;
		int notAcount = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == 'A') {
				visited[i] = true;
			} else {
				notAcount++;
			}
		}

		int nextIndex = 0;
		int idx = 0;
		for (int i = 0; i < notAcount; i++) {
			if (visited[nextIndex]) {
				// 방문했다면(알파벳 비용 계산이 끝났다면) A는 그냥 넘어가고 다음 인덱스 결정.
				int lidx = idx;
				int ridx = idx;
				int left = 0;
				int right = 0;

				while (visited[lidx]) {
					if (lidx == 0)
						lidx = name.length() - 1;
					else
						lidx--;
					left++;
				}

				while (visited[ridx]) {
					if(ridx + 1 >= name.length()) {
						right = Integer.MAX_VALUE;
						break;
					}else {
						ridx++;
						right++;
					}
				}

				if (left >= right) {
					idx = ridx;
					count += right;
				} else {
					idx = lidx;
					count += left;
				}
			}
			//System.out.println("index : "+idx);
			visited[idx] = true;//A가 아니면 방문했다고 표시하고 알파벳 비용 계산, 인덱스는 다음턴에 결정.
			int temp = name.charAt(idx);
			count += Integer.min(Math.abs(temp - 65), Math.abs(90 - temp) + 1);
		}
		return count;

	}
}