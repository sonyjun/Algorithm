package Programmers;

public class 자물쇠와열쇠 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } }));
	}

	public static boolean solution(int[][] key, int[][] lock) {

		// 홈이 있는 부분만, 부분적인 자물쇠를 만들기 위한 작업.
		int minI = Integer.MAX_VALUE;
		int minJ = Integer.MAX_VALUE;
		int maxI = Integer.MIN_VALUE;
		int maxJ = Integer.MIN_VALUE;
		boolean zeroExist = false;
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				if (lock[i][j] == 0) {
					zeroExist = true;
					minI = Math.min(minI, i);
					minJ = Math.min(minJ, j);
					maxI = Math.max(maxI, i);
					maxJ = Math.max(maxJ, j);
				}
			}
		}
		int[][] newLock;
		if (zeroExist) {
			// 홈이 있는 부분만, 부분적인 자물쇠 배열을 생성.
			newLock = new int[maxI - minI + 1][maxJ - minJ + 1];
			for (int i = minI; i <= maxI; i++) {
				for (int j = minJ; j <= maxJ; j++) {
					if (lock[i][j] == 0) {
						newLock[i - minI][j - minJ] = 1;
					}
					System.out.print(newLock[i - minI][j - minJ]+" ");
				}
				System.out.println();
			}
		} else {// 홈이 아예 없다. 맞는 키가 존재하지 않는다.
			return true;
		}

		// 부분적인 자물쇠와 열쇠의 일치 여부를 확인.
		for (int r = 0; r < 4; r++) {// 회전을 하면서 총 4번의 비교.
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key[0].length; j++) {
					
					// i,j를 시작으로 할 때 키와 비교 가능 범위에 있다면,
					if (key.length - i >= newLock.length && key[0].length - j >= newLock[0].length) {
						boolean keyPossible = true;
						//키와 만든 자물쇠를 비교.
						for (int I = i; I < i + newLock.length; I++) {
							for (int J = j; J < j + newLock[0].length; J++) {
								if (newLock[I - i][J - j] != key[I][J]) {
									keyPossible = false;
								}
							}
						}
						if (keyPossible) {//완벽하게 일치한다.
							return true;
						}
					}	
				}
			}
			newLock = rotate(newLock);// 90도 회전 시킴.
		}

		return false;
	}

	public static int[][] rotate(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] temp = new int[M][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[j][N - 1 - i] = arr[i][j];
			}
		}
		return temp;
	}
}
