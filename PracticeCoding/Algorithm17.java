package PracticeCoding;

import java.util.HashMap;
import java.util.Map;

public class Algorithm17 {
	public static void main(String args[]) {
		Solution17 s17 = new Solution17();
		String[][] clothes1 = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		String[][] clothes2 = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		System.out.println(s17.solution(clothes1));
		System.out.println(s17.solution(clothes2));
	}
}

class Solution17 {
	public int solution(String[][] clothes) {
		int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>(); // 종류 : 갯수

        for (int i = 0; i < clothes.length; i++) {
            // 종류 여부 판단. 같은 종류 일 경우 Value + 1
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
            								//해당 키가 존재할 경우, 해당 키에 존재하는 값을 반환.
            								//해당 키가 없을경우 0을 반환.
        }
        //System.out.println(clothesMap);

        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : clothesMap.values()){
            answer *= (val+1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
	}
}