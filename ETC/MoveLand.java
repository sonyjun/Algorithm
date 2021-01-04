package ETC;

public class MoveLand {
	public static void main(String args[]) {
		MoveLandSolution m = new MoveLandSolution();
		// m.solution(new int[][] { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 },
		// { 10, 10, 10, 20 } }, 3);
		m.solution(new int[][] { { 10, 11, 10, 11 }, { 2, 21, 20, 10 }, { 1, 20, 21, 11 }, { 2, 1, 2, 1 } }, 1);
	}
}

class MoveLandSolution {
	int color = 0;
	int[][] adjCost;

	public int solution(int[][] land, int height) {
		int[][] visited = new int[land.length][land.length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (visited[i][j] == 0) {
					++color;
					search(land, visited, i, j, height);
				}
			}
		}
		return color - 1;
	}

	public void search(int[][] land, int[][] visited, int indexI, int indexJ, int height) {
		visited[indexI][indexJ] = color;
		int currentValue = land[indexI][indexJ];
		if (indexJ + 1 < land.length && visited[indexI][indexJ + 1] == 0) {
			if (Math.abs(currentValue - land[indexI][indexJ + 1]) <= height) {
				search(land, visited, indexI, indexJ + 1, height);
			}
		}
		if (indexI + 1 < land.length && visited[indexI + 1][indexJ] == 0) {
			if (Math.abs(currentValue - land[indexI + 1][indexJ]) <= height) {
				search(land, visited, indexI + 1, indexJ, height);
			}
		}
		if (indexI - 1 >= 0 && visited[indexI - 1][indexJ] == 0) {
			if (Math.abs(currentValue - land[indexI - 1][indexJ]) <= height) {
				search(land, visited, indexI - 1, indexJ, height);
			}
		}
		if (indexJ - 1 >= 0 && visited[indexI][indexJ - 1] == 0) {
			if (Math.abs(currentValue - land[indexI][indexJ - 1]) <= height) {
				search(land, visited, indexI, indexJ - 1, height);
			}
		}
	}
}