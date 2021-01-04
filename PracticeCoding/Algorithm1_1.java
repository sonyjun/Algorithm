package PracticeCoding;

import java.util.TreeSet;
/*
정수 배열 numbers가 주어집니다. 
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
만들 수 있는 모든 수를 배열에 오름차순으로 담아
return 하도록 solution 함수를 완성해주세요.
 */
public class Algorithm1_1 {
	public static void main(String args[]) {
		Solution1 s = new Solution1();
		int[] numbers = {2,1,3,4,1};
		int[] numbers1 = {5,0,2,7};
		s.solution(numbers);
		s.solution(numbers1);
	}
}

class Solution1 {
	
	public int[] solution(int[] numbers) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				ts.add(numbers[i]+numbers[j]);
			}
		}
		int index = 0 ;
		int[] answer = new int[ts.size()];
		for(int i : ts) {
			answer[index++] = i;
			//System.out.print(i+ " ");
		}
		//System.out.println();
		return answer;
	}
}