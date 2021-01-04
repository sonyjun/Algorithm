package PracticeCoding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm20 {
	static int num = 1;// 1은 방문안한 그룹, 2~ 는 발견된 그룹부터 번호 매겨짐.
	static int[] array = new int[25];

	private static void solution(int sizeOfMatrix, int[][] matrix) {
		// TODO: 이곳에 코드를 작성하세요.
		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if (matrix[i][j] == 1) {
					num++;
					searchAround(i, j, matrix);
				}
			}
		}
		System.out.println(num - 1);
		Arrays.sort(array);
		for (int j = array.length - (num - 1) ; j < array.length; j++) {
			System.out.print(array[j]+" ");
		}
		
	}

	public static void searchAround(int i, int j, int[][] matrix) {// 본인이 1이니까 호출된거.
		matrix[i][j] = num; // 방문했다고 표시
		array[num]++;
		if (i + 1 < matrix.length) {
			if (matrix[i + 1][j] == 1) {// 아래쪽으로 도는거
				searchAround(i + 1, j, matrix);
			}
		}
		if (j + 1 < matrix.length) {
			if (matrix[i][j + 1] == 1) {// 오른쪽으로 도는거
				searchAround(i, j + 1, matrix);
			}
		}

		if (j - 1 >= 0) {
			if (matrix[i][j - 1] == 1) {// 왼쪽 도는거
				searchAround(i, j - 1, matrix);
			}
		}
		
		if (i -1 >= 0) {
			if (matrix[i-1][j] == 1) {// 윗쪽 도는거
				searchAround(i-1, j, matrix);
			}
		}
	}

	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		
		float start = System.nanoTime();
		InputData inputData = processStdin();
		solution(inputData.sizeOfMatrix, inputData.matrix);
		float end = System.nanoTime();
		System.out.println(end-start);
		/*double start = System.nanoTime();
		int[][] map = { { 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1 }, { 0, 0, 1, 1, 1 } };
		solution(5,map);
		double end = System.nanoTime();
		System.out.println(end-start);*/
	}
}
/*
public class adjMatrics_DFS {
	private static int[] X = { -1, 0, 1, 0 }; // X축의 상하좌우 이동을 위한 배열
	private static int[] Y = { 0, 1, 0, -1 }; // Y축의 상하좌우 이동을 위한 배열 (x,y 짝만 맞추어주면 상하좌우든 하좌우상 이든 순서 상관x)
	//private static int[][] map;
	private static int cnt = 1;
	
	private static void solution(int sizeOfMatrix, int[][] matrix) {
		// TODO: 이곳에 코드를 작성하세요.
		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		boolean[][] check = new boolean[matrix.length][matrix[0].length]; // 방문한 곳을 체크하기 위한 배열 행렬 생성
		adjMatrics_DFS b = new adjMatrics_DFS();
		for (int i = 0; i < matrix.length; i++) {
			// System.out.println("다음 찾기 시작");
			// (0,0) 부터 탐색 시작 후 1을 만나면 넓이 구하기 시작
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					b.dfs(i, j, check, matrix);
					arr.add(cnt);
					cnt = 1;
				}
				// 아닌경우 continue
				else
					continue;
			}
		}
		// System.out.println("프로그램 종료");
		System.out.println("arr : " + arr);
	}

	public void dfs(int x, int y, boolean[][] ck, int[][] map) {

		System.out.println(x + "," + y);
		ck[x][y] = true;
		map[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = x + X[i];
			int nextY = y + Y[i];
			System.out.println("0!");
			// 상,하,좌,우 이동 중 범위가 넘어서는 경우 continue
			if (nextX < 0 || nextY < 0 || nextX >= ck.length || nextY >= ck.length) {
				System.out.println("1!");
				continue;
			}
			// 방문한곳은 continue
			if (ck[nextX][nextY]) {
				System.out.println("2!");
				continue;
			}
			// 0은 벽이라서 이동할 경로가 벽이면 continue
			if (map[nextX][nextY] == 0) {
				System.out.println("3!");
				ck[nextX][nextY] = true;
				continue;
			}

			System.out.println("값증가전!");
			dfs(nextX, nextY, ck, map);
			System.out.println("값증가!");
			cnt++;
		}
		// System.out.println("END");
		// System.out.println();
	}

	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.sizeOfMatrix, inputData.matrix);
	}
}*/
