package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class RankSearch {
	public static void main(String[] args) {
		int[] answer = solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
	}

	public static int[] solution(String[] info, String[] query) {
		HashMap<String, ArrayList<Integer>> infos = new HashMap<>();
		for (String in : info) {
			String[] split = in.split(" ");
			int score = Integer.parseInt(split[4]);

			for (int i = 0; i < (1 << 4); i++) {
				StringBuilder key = new StringBuilder();

				for (int j = 0; j < 4; j++) {
					if ((i & (1 << j)) > 0)
						key.append(split[j]);
				}
				//만약 해당 키 값이 존재하지 않을 경우 새로운 ArrayList()를 선언하고 추가한다.
				infos.computeIfAbsent(key.toString(), (s) -> new ArrayList<>()).add(score);
			}
		}

		for (Entry<String, ArrayList<Integer>> entry : infos.entrySet()) {
			entry.getValue().sort(null);//키에 대한 값들인 List들을 정렬한다.
		}

		int[] answer = new int[query.length];
		ArrayList<Integer> empty = new ArrayList<>();
		for (int i = 0; i < query.length; i++) {
			String[] split = query[i].replaceAll("-", "").split(" and | ");
			String key = String.join("", split[0], split[1], split[2], split[3]);
			int score = Integer.parseInt(split[4]);

			ArrayList<Integer> list = infos.getOrDefault(key, empty);

			int s = 0, e = list.size();
			//찾으려는 값이 x이상의 값이라면, x보다 큰게 나올 때 까지 찾음. 본인이 들어갈 위치가 s로 나옴. 
			// list.size() - s를 하게 되면 score보다 큰 값들의 수가 나오게 된다.

			while (s < e) {
				int mid = (s + e) / 2;

				if (list.get(mid) < score)
					s = mid + 1;
				else
					e = mid;
			}

			answer[i] = list.size() - s;
		}
		return answer;

	}
}
