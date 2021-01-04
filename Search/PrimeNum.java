package Search;
import java.util.HashSet;

public class PrimeNum {
	public static void main(String args[]) {
		PrimeNumSolution p = new PrimeNumSolution();
		p.solution("0111");
		//p.solution("17");
		//p.solution("17");
	}
}

class PrimeNumSolution {
	HashSet<Integer> hm;
	public int solution(String numbers) {
		hm = new HashSet<Integer>();
		int n = numbers.length();
		int[] arr = new int[n];
		for (int i = 0; i < numbers.length(); i++) {
			arr[i] = Character.getNumericValue(numbers.charAt(i));
		}
		for (int i = 1; i <= arr.length; i++) {
			permutation(arr, 0, n, i);
		}
		int answer = hm.size();
		return answer;
	}

	public boolean IsPrimeNumber(int number) {
		if (number == 2) {
			hm.add(number);
			return true;
		}
		if (number == 1)
			return false;
		if (number % 2 == 0)
			return false; // 2를 제외한 소수는 항상 홀수 // 소수는 홀수 이므로 짝수로 나누는 과정을 생략한다.
		for (int n = 3; n < number; n += 2) {
			if (number % n == 0) {// 나누어 지므로 소수가 아니다.
				return false;
			}
		}
		hm.add(number);
		return true;
	}

	public void permutation(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			print(arr, r);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	public void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	public void print(int[] arr, int r) {
		String temp = "";
		for (int i = 0; i < r; i++) {
			temp += arr[i] + "";
		}
		IsPrimeNumber(Integer.parseInt(temp));
	}
}
