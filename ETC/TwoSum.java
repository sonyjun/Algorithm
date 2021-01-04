package ETC;

public class TwoSum {
	public static void main(String args[]) {
		TwoSumSolution t = new TwoSumSolution();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = t.twoSum(nums, target);
		System.out.println(answer[0] + "," + answer[1]);
	}
}

class TwoSumSolution {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}