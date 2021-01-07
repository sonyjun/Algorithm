package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink2 {
	static int[][] powerArr;
	static boolean[] isSelected;
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		powerArr = new int[num + 1][num + 1];
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num; j++) {
				powerArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[num + 1];
		int[] selectedPerson = new int[num / 2];
		//calPower(new int[] { 1, 4 });
		DFS(selectedPerson, 0);
	}

	private static void DFS(int[] selectedPerson, int selectNum) {
		// 끝나는 시점은 n/2명을 골랐을 때! 그때 나머지 팀과 비교해서 최소값 나오게.
		if (selectNum == num / 2) {
			for (int i : selectedPerson) {
				System.out.print(i);
			}
			System.out.println();
			calPower(selectedPerson);
			return;
		}

		for (int i = 1; i < isSelected.length; i++) {
			if (isSelected[i] == false) {
				selectedPerson[selectNum] = i;
				isSelected[i] = true;
				DFS(selectedPerson, selectNum + 1);
				isSelected[i] = false;
			}
		}
	}

	private static void calPower(int[] selectedPerson) {
		int sum = 0;
		for (int i = 0; i < selectedPerson.length - 1; i++) {
			int x = selectedPerson[i];
			//System.out.println("x:"+x);
			for (int j = i + 1; j < selectedPerson.length; j++) {
				int y = selectedPerson[j];
				//System.out.println("y:"+y);
				//System.out.println("powerArr[x][y] :"+powerArr[x][y]+" powerArr[y][x]: "+powerArr[y][x]);
				sum += powerArr[x][y] + powerArr[y][x];
			}
		}
		System.out.println(sum);
	}
}
