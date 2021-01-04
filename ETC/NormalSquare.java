package ETC;

public class NormalSquare {
	public static void main(String args[]) {
		NormalSquareSolution n = new NormalSquareSolution();
		n.solution(100000000,999999999);
	}
}

class NormalSquareSolution {
	public long solution(int w, int h) {
		long gcdValue = gcd(Math.max(w, h), Math.min(w, h));
		long minW = (long)w / gcdValue;
		long minH = (long)h / gcdValue;
		long garbage = minW + minH - 1;
		long answer = ((long)w * (long)h) - (garbage * gcdValue);
		return answer;
	}

	public long gcd(int a, int b) {
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}
