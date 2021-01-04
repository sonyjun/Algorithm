package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
4
S 100 3
W 50 1
S 10 1
 */
public class SheepEscape {
	static int totalSheepNum = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int islandNum = Integer.parseInt(br.readLine());
		LinkedList<Island>[] adjList = new LinkedList[islandNum + 1];
		StringTokenizer st;
		for(int i = 1; i < adjList.length ; i ++) {
			adjList[i] = new LinkedList<Island>();
		}
		//adjList[adjList.length-1] = new LinkedList<Island>();
		for (int i = 1; i < adjList.length - 1; i++) {
			//adjList[i] = new LinkedList<Island>();
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			long count = Integer.parseInt(st.nextToken());
			int adjVertex = Integer.parseInt(st.nextToken());
			int who;
			if (temp.equals("S")) {// 양이면 고유번호 1
				who = 1;
			} else {// 늑대면 고유번호 2
				who = 2;
			}
			adjList[adjVertex].add(new Island(who, count, i + 1));
		}

		/*for (int i = 1; i < adjList.length; i++) {
			for (int j = 0; j < adjList[i].size(); j++) {
				//System.out.println(i + "의 인접 섬 정보 : " + adjList[i].get(j).vertex);
			}
		}*/
		System.out.println(postOrder(adjList, new Island(0, 0, 1)));
	}

	public static long postOrder(LinkedList<Island>[] adjList, Island visitIsland) {
		//후위 순회를 하게 되면, 리프 노드부터 왼쪽자식 오른쪽 자식 본인 순으로 루트가 제일 마지막으로 돌게 끔 되어있음.
		//또 각각의 return값을 부모에게 전달해줌으로써 아래부터 누적될 수 있다.
		//이때 중요한 점음 누적이라는 효과를 누리기 위해 sum+= preorder()을 해주는 것이 핵심...
		//System.out.println("몇번.");
		long sum = 0;
		for (int i = 0; i < adjList[visitIsland.vertex].size(); i++) {
			Island adjIsland = adjList[visitIsland.vertex].get(i);
			//인접한 녀석의 인접한 녀석의 인접한 녀석~~~~ 리프까지 가게 되는데, 리프는 인접한 친구가 없기때문에 아래 조건문 시행.
			//리프가 끝나게되면 부모가 시행되고 그 부모에 값전달이 되고 그런 식으로..
			sum += postOrder(adjList, adjIsland);
		}
		/*for (Island adjIsland : adjList[visitIsland.vertex]) {
			sum += postOrder(adjList, adjIsland);
		}*/
		
		if (visitIsland.who == 1) {// 방문한 친구가 양이라면
			return sum + visitIsland.count;
		} else {// 방문한 친구가 늑대라면, 혹은 루트라면..
			return (sum - visitIsland.count) >= 0 ? sum - visitIsland.count : 0;
		}
	}
}

class Island {
	// 1:양
	// 2:늑대
	int who;
	long count;
	int vertex;

	public Island(int who, long count, int vertex) {
		this.who = who;
		this.count = count;
		this.vertex = vertex;
	}
}