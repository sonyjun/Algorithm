package Programmers;

public class Level1_1_1 {

	static int[] a = new int[1000001];
	
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(5));
	}
	public static int solution(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {//2부터 돌리는 이유는 1의 배수로 다루면 안되니까.
											//1은 이미 소수임+ 이 알고리즘의 원리
			if (a[i] == 1)// 1이 되었을 때를 삭제되었다는 걸로 정의. 즉 소수가 아니다.
				continue;
			//해설 : 1. 해당 숫자가 지워져있다. 소수가 아니다.(위에서걸림)
			//		2. 해당 숫자가 안지워져있다. 나의 배수는 다 지워야한다.(아래서처리)
			for (int j = 2 * i; j <= n; j += i) {//배수를 지우는 작업.
				a[j] = 1;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (a[i] == 0) {
				count++;
			}
		}
		return count;
    }
}
