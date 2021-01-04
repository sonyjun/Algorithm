package ETC;
//규칙 찾는게.. 너무 어려워........
public class TriangleSnail {
	public static void main(String args[]) {
		TriangleSnailSolution t = new TriangleSnailSolution();
		t.solution(5);
	}
}

class TriangleSnailSolution {
	public int[] solution(int n) {
		int[] answer = new int[(n * (n + 1)) / 2];

		for (int i : answer) {
			System.out.print(i + " ");
		}
		return answer;
	}

	public void upToLeft() {

	}

	public void LeftToRight() {

	}

	public void RightToUp() {

	}
}