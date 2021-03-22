package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args) {
		solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork",
				"LA" });
		solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" });
		solution(2, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
				"Jeju", "NewYork", "Rome" });
		solution(5, new String[] { " Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome",
				"Paris", "Jeju", "NewYork", "Rome" });
		solution(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" });
		solution(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" });

	}

	public static int solution(int cacheSize, String[] cities) {
		Queue<String> que = new LinkedList<String>();
		System.out.println("원래 : " + que);
		int cost = 0;
		for (int i = 0; i < cities.length; i++) {
			if (que.contains(cities[i].toUpperCase())) {
				cost += 1;
				que.remove(cities[i].toUpperCase());
				que.add(cities[i].toUpperCase());
				//System.out.println("hit : " + que);
			} else {
				cost += 5;
				//System.out.println(que.size());
				if (que.size() < cacheSize) {
					que.add(cities[i].toUpperCase());
					//System.out.println("어디돈겨 1");
				} else if(que.size() != 0){
					que.poll();
					que.add(cities[i].toUpperCase());
					//System.out.println("어디돈겨 2");
				}
				//System.out.println("miss : " + que);
			}
			// 포함하던 포함안하던 캐시에 넣어야지, 하지만 사이즈 체크하고 넣어야지.

		}
		//System.out.println(cost);
		return cost;
	}
}
