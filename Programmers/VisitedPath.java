package Programmers;

public class VisitedPath {
	static final int U = 0;
	static final int D = 1;
	static final int L = 2;
	static final int R = 3;

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}

	public static int solution(String dirs) {
		int[][] field = new int[11][11];
		boolean[][][] visited = new boolean[11][11][4];// U D L R 이력을 관리.
		int currentI = 5;
		int currentJ = 5;
		int nextI = 0;
		int nextJ = 0;
		int count = 0;
		for (int i = 0; i < dirs.length(); i++) {
			if (dirs.charAt(i) == 'U') {
				nextI = currentI - 1;
				nextJ = currentJ;
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;// 못가는 좌표임.
				}
				// 갈수 있다면.. 갔던 좌표인지 안갔던 좌표인지 확인. 무조건 가긴 감.
				if (visited[currentI][currentJ][U] == false) {// 현재 위치에서 위로간 이력이 없다면
					count++;
					visited[currentI][currentJ][U] = true;
					visited[nextI][nextJ][D] = true;// 위 입장에서는 아래로 간 이력이 있다 해줌
				}
			} else if (dirs.charAt(i) == 'D') {
				nextI = currentI + 1;
				nextJ = currentJ;
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;// 못가는 좌표임.
				}
				if (visited[currentI][currentJ][D] == false) {// 현재 위치에서 아래로 간 이력이 없다면
					count++;
					visited[currentI][currentJ][D] = true;
					visited[nextI][nextJ][U] = true;// 아래 입장에서는 위로 간 이력이 있다고 해줌
				}
			} else if (dirs.charAt(i) == 'L') {
				nextI = currentI;
				nextJ = currentJ - 1;
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;// 못가는 좌표임.
				}
				if (visited[currentI][currentJ][L] == false) {// 현재 위치에서 왼쪽으로간 이력이 없다면,
					count++;
					visited[currentI][currentJ][L] = true;
					visited[nextI][nextJ][R] = true;
				}
			} else if (dirs.charAt(i) == 'R') {
				nextI = currentI;
				nextJ = currentJ + 1;
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;// 못가는 좌표임.
				}
				if (visited[currentI][currentJ][R] == false) {// 현재 위치에서 오른쪽으로 간 이력이 없다면,
					count++;
					visited[currentI][currentJ][R] = true;
					visited[nextI][nextJ][L] = true;
				}
			}
			currentI = nextI;
			currentJ = nextJ;
		}
		return count;
	}
}
