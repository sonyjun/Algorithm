package ETC;

public class TGDtraffic {
	public static void main(String args[]) {
		TGDtrafficSolution t = new TGDtrafficSolution();
		String[] lines = new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		t.solution(lines);
	}
}

class TGDtrafficSolution {
	public int solution(String[] lines) {
		long[][] startEndArr = new long[lines.length][2];
		String[] temp;
		String[] sliceTime;
		for (int i = 0; i < lines.length; i++) {
			temp = lines[i].split(" ");
			sliceTime = temp[1].split(":");
			long startTime = 0;
			long endTime = 0;
			endTime += Integer.parseInt(sliceTime[0]) * 60 * 60 * 1000;
			endTime += Integer.parseInt(sliceTime[1]) * 60 * 1000;
			endTime += (int) (Double.parseDouble(sliceTime[2]) * 1000);
			startTime = endTime - (int) (Double.parseDouble(temp[2].replace("s", "")) * 1000) + 1;
			startEndArr[i][0] = startTime;
			startEndArr[i][1] = endTime;
		}
		/*
		 * for (int i = 0; i < startEndArr.length; i++) { System.out.println("start: " +
		 * startEndArr[i][0] + ", end : " + startEndArr[i][1]); }
		 */
		int max = 0;
		for (int i = 0; i < startEndArr.length; i++) {
			long checkStartTime = startEndArr[i][0];
			long checkEndTime = checkStartTime + 1000;

			int count = 0;
			for (int j = 0; j < startEndArr.length; j++) {
				if (startEndArr[j][0] >= checkStartTime && startEndArr[j][0] < checkEndTime) {
					count++;
				} else if (startEndArr[j][1] >= checkStartTime && startEndArr[j][1] < checkEndTime) {
					count++;
				} else if (startEndArr[j][0] <= checkStartTime && startEndArr[j][1] >= checkEndTime) {
					count++;
				}
			}
			if (max < count) {
				max = count;
			}

			checkStartTime = startEndArr[i][1];
			checkEndTime = checkStartTime + 1000;

			count = 0;
			for (int j = 0; j < startEndArr.length; j++) {
				if (startEndArr[j][0] >= checkStartTime && startEndArr[j][0] < checkEndTime) {
					count++;
				} else if (startEndArr[j][1] >= checkStartTime && startEndArr[j][1] < checkEndTime) {
					count++;
				} else if (startEndArr[j][0] <= checkStartTime && startEndArr[j][1] >= checkEndTime) {
					count++;
				}
			}
			if (max < count) {
				max = count;
			}
		}
		return max;
	}
}