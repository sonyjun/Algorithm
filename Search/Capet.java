package Search;

public class Capet {
	public static void main(String args[]) {
		CapetSolution c = new CapetSolution();
		int brown = 10;
		int yellow = 2;
		c.solution(brown, yellow);
		c.solution(8, 1);
		c.solution(24, 24);
	}
}

class CapetSolution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = (brown + 4) / 2;
		for (int x = 3; x < sum; x++) {
			int y = sum - x;
			if (x >= y && ((x - 2) * (y - 2)) == yellow) {
				answer[0] = x;
				answer[1] = y;
				System.out.println("x : "+x+" y : "+y);
				break;
			}
		}
		return answer;
	}
}
