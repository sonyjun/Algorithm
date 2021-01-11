package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink {
	static int[][] powerArr;
	static boolean[] isSelected;
	static int num;
	static int powerIndex = 0;
	static int[] teamPowerArr;

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
		teamPowerArr = new int[200000];
		int[] selectedPerson = new int[num / 2];
		DFS(selectedPerson, 0, 0);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < powerIndex / 2; i++) {
			min = Math.min(min, Math.abs(teamPowerArr[i] - teamPowerArr[powerIndex - i - 1]));
		}
		System.out.println(min);
	}

	private static void DFS(int[] selectedPerson, int selectNum, int index) {// 현재 선택한 사람들이 selectedPerson으로 드감.
																				// selectNum은 현재 뽑 인원수
																				// index는 내가 고른 사람의 번호
		// 끝나는 시점은 n/2명을 골랐을 때! 그때 나머지 팀과 비교해서 최소값 나오게
		if (selectNum == num / 2) {
			teamPowerArr[powerIndex++] = calPower(selectedPerson); // 최종적으로 뽑은 n/2명의 사람의 능력치. selectedPerson 배열에 결성된 팀이 있음.
			// 결국 중복없이 세명 뽑는 경우가 모두 teamPowerArr에 들어감.
			// 예를 들어 123456 중에 136이 뽑히는 경우가 있다면 245가 뽑히는 경우도 이 배열에 들어간다는 말. 중복이 없이 뽑히도록 구현했으므로..
			return;
		}

		for (int i = index + 1; i < isSelected.length; i++) {// i번째 사람을 뽑을 때. i를 index+1부터 시작해줌으로서 중복을 피할 수 있음.(조합의 원리)
			if (isSelected[i] == false) {
				selectedPerson[selectNum] = i;
				isSelected[i] = true;
				DFS(selectedPerson, selectNum + 1, i);
				isSelected[i] = false;
			}
		}
	}

	private static int calPower(int[] selectedPerson) {// 배열에 속한 팀들의 능력치를 계산
		int sum = 0;
		for (int i = 0; i < selectedPerson.length - 1; i++) {
			int x = selectedPerson[i];
			for (int j = i + 1; j < selectedPerson.length; j++) {
				int y = selectedPerson[j];
				sum += powerArr[x][y] + powerArr[y][x];
			}
		}
		return sum;
	}
}
