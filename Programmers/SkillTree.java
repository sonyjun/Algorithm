package Programmers;

public class SkillTree {
	public static void main(String[] args) {
		System.out
				.println(solution("BDC", new String[] { "AAAABACA", "CBADF", "AECB", "BDA", "DBCJGINVJ", "FF", "D" }));
	}

	public static int solution(String skill, String[] skill_trees) {
		int count = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			String changedStr = skill_trees[i].replaceAll("[^" + skill + "]", "");
			// System.out.println(changedStr);
			//System.out.println("original : " + skill_trees[i]);
			//System.out.println("changedStr : " + changedStr);
			if (changedStr.length() > 0 && skill.contains(changedStr) && changedStr.charAt(0) == skill.charAt(0)) {
				count++;
				//System.out.println("통과");
			} else if (changedStr.length() == 0) {
				//System.out.println("통과");
				count++;
			}
		}
		return count;
	}
}
