package Programmers;

public class JoyStick {
	public static void main(String[] args) {
		System.out.println(solution("AAABB"));
		//System.out.println(solution("JEROEN"));
		//System.out.println(solution("JAN"));
	}

	public static int solution(String name) {
		// 알파벳 바꾸는 비용 계산.
		int count = 0;
		int nonAcount = 0;
		boolean[] visited = new boolean[name.length()];
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				count += Math.min(name.charAt(i) - (int) 'A',(int) 'Z' - name.charAt(i) + 1);
				nonAcount++;
			}
		}
		// 좌우로 이동하는 비용 계산.
		int cursor = 0;// 0번째에 커서가 놓임으로 시작.
		int i = 0;
		int j = 0;
		int leftIdx = 0;
		int leftCount = 0;
		int rightIdx = 0;
		int rightCount = 0;
		if(name.charAt(0) != 'A') {
			nonAcount--;
		}
		visited[cursor] = true;
		for (int t = 0; t < nonAcount; t++) {
			
			for (i = cursor + 1; i < name.length(); i++) {
				if (name.charAt(i) != 'A' && visited[i] == false) {
					break;
				}
			}
			if(i >= name.length()) {
				rightCount = Integer.MAX_VALUE;
				rightIdx = i;
			}else {
				rightCount = i - cursor;
				rightIdx = i;
			}
			

			for (i = cursor - 1; i >= 0; i--) {
				if (name.charAt(i) != 'A' && visited[i] == false) {
					break;
				}
			}
			if (i < 0) {// 왼쪽까지 다 돌았는데 나온 값이 없을 때. 오른쪽 끝으로 가야될 때
				for (j = name.length() - 1; j > cursor; j--) {
					if (name.charAt(j) != 'A' && visited[j] == false) {
						break;
					}
				}
				leftCount = name.length() - j + cursor;
				leftIdx = j;
			} else {// 왼쪽에서 나왓을 때.
				leftCount = cursor - i;
				leftIdx = i;
			}
			if (leftCount < rightCount) {
				cursor = leftIdx;
				visited[cursor] = true;
				count += leftCount;
			} else {
				cursor = rightIdx;
				visited[cursor] = true;
				count += rightCount;
			}
		}
		// System.out.println(right);

		return count;
	}
}
