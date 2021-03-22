package Programmers;

public class Level3_4_1 {
	static int N;
	static int count = 0;
	static int[] cols;

	public static void main(String[] args) {
		solution(8);
	}

	public static int solution(int n) {
		cols = new int[n];
		N = n;
		backTracking(0);
		System.out.println(count);
		return count;
	}

	// level은 이번에 내가 위치를 선택해야되는 행이다.
	// 0 번째 행의 0번째 열에 놓는 걸 시작으로 n-1번째 행에 놓을 때까지 모든 경우의 수를 따지며 간다.
	public static void backTracking(int level) {
		if (level == N) {// 최종 단계에 이르렀음.
			count++;
			return;
		}
		for (int j = 0; j < N; j++) {
			cols[level] = j; // level에 해당되는 행에 j열에 퀸을 놓아보겠다. 각 level(0~n-1)단계별로 위치 다 놓아봄.
			if (isPossible(level)) {//위에서 놓은 위치가 가능한 위치인지 확인. 가능하면 다음 단계로.
				backTracking(level + 1);
			}
		}
	}

	public static boolean isPossible(int level) {// 해당 레벨에 놓은 값이 가능한 위치인지.
		for (int i = 0; i < level; i++) {
			// level의 행보다 작은 행들의 퀸의 위치를 살펴보며, 대각에 위치한 녀석인지 직선거리 녀석인지 확인.
			// cols[i] == cols[level] : 같은 열에 위치해 있는지.
			// 같은 행인지는 비교할 필요가 없는게 0번째 부터 n-1번째까지 하나씩 놓으면서 이동하기 때문.
			if (cols[i] == cols[level] || Math.abs(i - level) == Math.abs(cols[i] - cols[level])) {
				return false;
			}
		}
		return true;
	}
}
