package Programmers;

public class Triangle {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));
	}

	public static int solution(int[][] triangle) {
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j];
			}
		}
		return triangle[0][0];
	}
}
