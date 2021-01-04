package PracticeCoding;

//https://programmers.co.kr/learn/courses/30/lessons/60059

public class Algorithm7 {
	public static void main(String args[]) {
		solution7 s7 = new solution7();
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(s7.solution(key, lock));
		/*
		 * for(int i= 0 ; i < key.length ; i++) { for(int j= 0 ; j < key.length ; j++) {
		 * System.out.print(key[i][j]+" "); } System.out.println(); }
		 */
	}
}

class solution7 {

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		for(int i = 0; i < 3; i ++) {
			answer = makeSearchSell(key, lock);
			if(answer == true) {
				return true;
			}else {
				key = rotate(key);
				answer = makeSearchSell(key,lock);
			}
		}
		//makeSearchSell(rotate(key),lock);
		return answer;
	}

	public int[][] rotate(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotate = new int[m][n];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = arr[n - 1 - j][i];
			}
		}

		return rotate;
	}

	public boolean makeSearchSell(int[][] key, int[][] lock) {// 탐색을 위한 가상의 셀을 만드는 메소드
		int cellSize = (key.length - 1) * 2 + lock.length;
		int lockStartX = key.length - 1;
		int lockStartY = key.length - 1;
		int lockEndX = key.length - 1 + lock.length;
		int lockEndY = key.length - 1 + lock.length;
		int[][] cellArr = new int[cellSize][cellSize];

		for (int y = lockStartY; y < lockEndY; y++) {// 만든 cell의 가운데에 lock채우는 부분.
			for (int x = lockStartX; x < lockEndX; x++) {
				cellArr[y][x] = lock[y - lockStartY][x - lockStartX];
			}
		}
/*
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {
				System.out.print(cellArr[i][j] + " ");
			}
			System.out.println();
		}*/
		return setXY_Postion(cellArr, key, lock);
	}

	public boolean setXY_Postion(int[][] solutionCell, int[][] key, int[][] lock) {
		//꼭지점을 정하고 어디서부터 어디까지 검사가 이루어 져야 하는지 루프문 작성.
		//x,y 좌표의 범위를 정하고 각 좌표에서의 값이 해답인지를 확인하는 메소드 호출.
		
		int startX = 0;// 시작점(key의 왼쪽위 꼭지점의 처음 좌표는 0,0이다.
		int startY = 0;// 시작점(key의 왼쪽위 꼭지점의 처음 좌표는 0,0이다.
		int endX = key.length + lock.length - 1;// 끝나는지점 key의 왼쪽위 꼭지점의 마지막 좌표를 구하는 식.
		int endY = key.length + lock.length - 1;
		//0,0부터 
		for (int y = startY; y < endY; y++) {
			for (int x = startX; x < endX; x++) {
				//System.out.println("x : "+x +" y : "+y );
				if(fillKeyToCell(solutionCell,key,lock,x,y))
					return true;
			}
		}
/*
		System.out.println("-------solutionCell------------");
		for (int i = 0; i < solutionCell.length; i++) {
			for (int j = 0; j < solutionCell.length; j++) {
				System.out.print(solutionCell[i][j] + " ");
			}
			System.out.println();
		}*/
		return false;
	}
	
	public boolean fillKeyToCell(int[][] solutionCell,int[][]key,int[][] lock,int getX, int getY){
		//탐색을 위한 가상 셀에 정해진 꼭지점을 시작점으로 하여 key를 대입하는 메소드
		int[][] tempCell = new int[solutionCell.length][solutionCell.length];
		
		for(int i= 0 ; i < solutionCell.length ; i++) {//solution셀은 계속 리셋되어 사용되어야하기 때문에 복사한 배열을 이용
			System.arraycopy(solutionCell[i], 0,tempCell[i] , 0, solutionCell[0].length);
		}
		for (int y = getY; y < getY+ key.length; y++) {
			for (int x = getX; x < getX + key.length ; x++) {
				tempCell[y][x] += key[y-getY][x-getX];
			}
		}
/*
		System.out.println("--------tempCell------------");
		for (int i = 0; i < tempCell.length; i++) {
			for (int j = 0; j < tempCell.length; j++) {
				System.out.print(tempCell[i][j] + " ");
			}
			System.out.println();
		}
		*/
		return checkIsCorrect(tempCell,key,lock);
	}
	
	public boolean checkIsCorrect(int[][] makedForCheckCell,int[][] key,int[][] lock){
		int lockStartX = key.length - 1;
		int lockStartY = key.length - 1;
		int lockEndX = key.length - 1 + lock.length;
		int lockEndY = key.length - 1 + lock.length;
		for (int y = lockStartY; y < lockEndY; y++) {
			for (int x = lockStartX; x < lockEndX ; x++) {
				if(makedForCheckCell[y][x] == 0 || makedForCheckCell[y][x] == 2) {
					return false;
				}
			}
		}
		return true;
	}
}
