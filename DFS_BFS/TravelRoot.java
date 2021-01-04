package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;

//DFS와 BFS는 무조건 다 돌려서 결과값을 분석해 최적의 해를 찾을 수도 있고,
//그때마다 최적의 선택을 해서 하나의 해가 나오게 할 수 있음.

public class TravelRoot {
	public static void main(String args[]) {
		TravelRootSolution t = new TravelRootSolution();
		t.solution(new String[][] { { "ICN", "A" }, { "ICN", "B" }, { "B", "ICN" } });
		t.solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		t.solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } });
	}
}

class TravelRootSolution {
	ArrayList<String> arrAnswer;
	int index = 0;

	public String[] solution(String[][] tickets) {
		boolean[] visited = new boolean[tickets.length];
		String[] answer = new String[tickets.length + 1];
		arrAnswer = new ArrayList<String>();
		DFS(tickets, visited, "ICN", "ICN");
		Collections.sort(arrAnswer);
		answer = arrAnswer.get(0).split(" ");
		return answer;
	}

	public void DFS(String[][] tickets, boolean[] visited, String start, String answer) {
		if (answer.split(" ").length == tickets.length + 1) {
			arrAnswer.add(answer);
		}
		for (int i = 0; i < tickets.length; i++) {// 항공권 갯수만큼 루프돔

			// 출발지가 같고, 아직 미사용 항공권이라면
			if (tickets[i][0].equals(start) && visited[i] == false) {
				visited[i] = true;// 방문했다하고 재귀호출 실시. 해당 인덱스가 방문되었다고 가정하에 
				DFS(tickets, visited, tickets[i][1], answer + " " + tickets[i][1]);
				visited[i] = false;// 위의 방문이 끝났으면 올바르다면 answer까지 갓을거임
									// 하지만 그게 우선순위가 아닌경우 다른 항공권도 봐야하므로 방문안했다고하고 다음껄 방문할 수 있도록 설정.
			}
		}
	}
}