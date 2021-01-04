package DFS_BFS;

public class IncodeWord {
	public static void main(String args[]) {
		IncodeWordSolution i = new IncodeWordSolution();
		System.out.println(i.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(i.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log" }));
	}
}

class IncodeWordSolution {
	int num;

	public int solution(String begin, String target, String[] words) {
		num = Integer.MAX_VALUE;
		boolean[] visited = new boolean[words.length];
		DFS(begin, visited, words, target, 0);
		if (num == Integer.MAX_VALUE) {
			return 0;
		} else {
			return num-1;
		}
	}

	public int differNum(String a, String b) {
		int num = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				num++;
			}
		}

		return num;
	}

	public void DFS(String currentWord, boolean[] visited, String[] words, String target, int count) {
		// System.out.println(currentWord);
		if (currentWord.equals(target)) {
			if (num > count) {
				num = count;
			}
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (differNum(currentWord, words[i]) == 1 && visited[i] == false) {
				//System.out.println("current : " + currentWord);
				//System.out.println("next : " + words[i]);
				visited[i] = true;
				DFS(words[i], visited.clone(), words, target, ++count);
			}
		}
	}
}
