package Programmers;

public class ThanksGivingDay {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" }));
		System.out.println(solution(new String[] { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" }));
		System.out.println(solution(new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" }));

	}

	public static int solution(String[] lines) {
		int[][] StartEndTime = new int[lines.length][2];// [i][0] : 시작시간, [i][1] : 끝나는 시간
		for (int i = 0; i < StartEndTime.length; i++) {
			String[] temp = lines[i].split(" ");
			int second = (int) (Double.parseDouble(temp[2].replace("s", "")) * 1000);
			temp = temp[1].split(":");
			StartEndTime[i][1] = Integer.parseInt(temp[0]) * 60 * 60 * 1000 + Integer.parseInt(temp[1]) * 60 * 1000
					+ (int)(Double.parseDouble(temp[2]) * 1000);
			StartEndTime[i][0] = StartEndTime[i][1] - second + 1;
		} // 시작시간과 끝나는 시간 결정
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < StartEndTime.length; i++) {
			int count = 0;

			// 왼쪽 경계를 기준으로
			int startTime = StartEndTime[i][0];
			int endTime = StartEndTime[i][0] + 999;
			//System.out.println("왼쪽 경계 : " + startTime + " ~ " + endTime);
			for (int j = 0; j < StartEndTime.length; j++) {
				if (startTime <= StartEndTime[j][0] && StartEndTime[j][0] <= endTime) {
					count++;
				} else if (startTime <= StartEndTime[j][1] && StartEndTime[j][1] <= endTime) {
					count++;
				} else if (StartEndTime[j][0] < startTime && StartEndTime[j][1] > endTime) {
					count++;
				}
			}
			count = 0;
			// 오른쪽 경계를 기준으로
			startTime = StartEndTime[i][1];
			endTime = StartEndTime[i][1] + 999;
			//System.out.println("오른쪽 경계 : " + startTime + " ~ " + endTime);
			for (int j = 0; j < StartEndTime.length; j++) {
				if (startTime <= StartEndTime[j][0] && StartEndTime[j][0] <= endTime) {
					//System.out.println(StartEndTime[j][0] + "~" + StartEndTime[j][1] + " 들어옴");
					count++;
				} else if (startTime <= StartEndTime[j][1] && StartEndTime[j][1] <= endTime) {
					count++;
				} else if (StartEndTime[j][0] < startTime && StartEndTime[j][1] > endTime) {
					count++;
				}
			}

			answer = Math.max(answer, count);
		}
		return answer;
	}
}
