package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Collections;

public class BestAlbum_1 {
	public static void main(String args[]) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		BestAlbumSolution_1 s = new BestAlbumSolution_1();
		s.solution(genres, plays);
	}
}

class BestAlbumSolution_1 {
	public int[] solution(String[] genres, int[] plays) {

		HashMap<String, Object> genresMap = new HashMap<String, Object>(); // <장르, 곡 정보>
		HashMap<String, Integer> playMap = new HashMap<String, Integer>(); // <장르, 총 장르 재생수>
		ArrayList<Integer> resultAL = new ArrayList<Integer>();

		for (int i = 0; i < genres.length; i++) {
			String key = genres[i];
			HashMap<Integer, Integer> infoMap; // 곡 정보 : <곡 고유번호, 재생횟수>

			if (genresMap.containsKey(key)) {//이미 존재하는 값이라면
				//기존에 해시맵의 키,값 쌍에서 값에 해시맵이 또 들어가있는 상태이므로.. 
				//그 해시맵을 다시 불러옴, 그 해시맵을 갱신시켜주기 위한 작업임.
				infoMap = (HashMap<Integer, Integer>) genresMap.get(key);
			} else {
				//없다면 새로 생성.
				infoMap = new HashMap<Integer, Integer>();
			}

			infoMap.put(i, plays[i]);// 장르 안에 또 고유번호,재생횟수 쌍으로 구성되어있는 형태.
			genresMap.put(key, infoMap);// 해당 장르에 맞게 값에 해당되는 해시맵을 넣어줌.

			// 재생수
			if (playMap.containsKey(key)) {
				playMap.put(key, playMap.get(key) + plays[i]);
			} else {
				playMap.put(key, plays[i]);
			}
		}

		Iterator it = sortByValue(playMap).iterator();

		while (it.hasNext()) {
			String key = (String) it.next();
			Iterator indexIt = sortByValue((HashMap<Integer, Integer>) genresMap.get(key)).iterator();
			int playsCnt = 0;

			while (indexIt.hasNext()) {
				resultAL.add((int) indexIt.next());
				playsCnt++;
				if (playsCnt > 1)
					break;
			}
		}

		int[] answer = new int[resultAL.size()];

		for (int i = 0; i < resultAL.size(); i++) {
			answer[i] = resultAL.get(i).intValue();
		}

		return answer;
	}

	private ArrayList sortByValue(final Map map) {
		ArrayList<Object> keyList = new ArrayList();
		keyList.addAll(map.keySet());
		
		Collections.sort(keyList, new Comparator() {//실질적으로 Object는 장르이름임.
			//저 리스트의 값들을 원하는 순서로 정렬하고자 하는 것.
			//두 값이 어떻게 비교가 이루어지게 하는지만 정의해주면 됨.
			//여기서는 총 재생횟수로 정렬하려는 것인데, 비교가 되어질 값을 v1,v2에 넣어준다.
			//이때 v1,v2의 실질적으로 Int값임. 
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
				//comparator도 결국 1,-1,0을 바노한해주는 형식으로 가야되는데, object가 integer형태이므로,
				// Comparable로 형변환 후에 compareTo 메소드를 이용.
			}
		});

		return keyList;
	}
}