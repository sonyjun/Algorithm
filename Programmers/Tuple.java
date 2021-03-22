package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Tuple {
	public static void main(String[] args) {
		int[] answer1 = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		int[] answer2 = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
		int[] answer3 = solution("{{20,111},{111}}");
		int[] answer4 = solution("{{123}}");
		int[] answer5 = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
	}

	public static int[] solution(String s) {
		String[] input = s.split("\\},\\{");
		input[0] = input[0].replace("{{", "");
		input[input.length - 1] = input[input.length - 1].replace("}}", "");
		int[] answer = new int[input.length];
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}

		});
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();// 얘는 누적용도.
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			String[] temp = input[i].split(",");
			HashMap<Integer, Integer> tempHm = (HashMap<Integer, Integer>) hm.clone();// 얘는 값 건드려도 됨. 확인용도.
			for (int j = 0; j < temp.length; j++) {
				//System.out.println("temp : " + temp[j]);
				if (tempHm.containsKey(Integer.parseInt(temp[j])) && tempHm.get(Integer.parseInt(temp[j])) != 0) {
					// 이미 존재하는 값이고 개수가 1개 이상이라면.
					hm.put(Integer.parseInt(temp[j]), hm.getOrDefault(Integer.parseInt(temp[j]), 0) + 1);
					tempHm.put(Integer.parseInt(temp[j]), hm.getOrDefault(Integer.parseInt(temp[j]), 0) - 1);
				} else {// 존재하지 않으면 정답에 추가.
					hm.put(Integer.parseInt(temp[j]), hm.getOrDefault(Integer.parseInt(temp[j]), 0) + 1);
					answer[index++] = Integer.parseInt(temp[j]);
					break;
				}
			}
		}
		/*
		 * for (int i = 0; i < answer.length; i++) { System.out.print(answer[i] + " ");
		 * } System.out.println();
		 */
		return answer;
	}
}
