package DFS_BFS;

public class TargetNum {
	public static void main(String args[]) {
		TargetNumSolution t = new TargetNumSolution();
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(t.solution(numbers, target));
	}
}

class TargetNumSolution {
	int target;

	public int solution(int[] numbers, int target) {
		this.target = target;
		return DFSresult(numbers, 0, 0);
	}

	public int DFSresult(int[] numbers, int nextIndex, int sum) {
		if (numbers.length == nextIndex) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return DFSresult(numbers, nextIndex + 1, sum - numbers[nextIndex])
				+ DFSresult(numbers, nextIndex + 1, sum + numbers[nextIndex]);
		//0번째 인덱스의 값을 +,-로 sum을 계산해서 넘겨줌. 다음 차례는 1번째 인덱스 계산해주고 넘기면 됨.
		//최종적으로 nextIndex는 마지막 인덱스를 넘어 numbers의 크기와 같아졌다면 최종계산 후 리턴.
	}
}