package ETC;

public class SkillTree {
	public static void main(String args[]) {
		SkillTreeSolution s = new SkillTreeSolution();
		s.solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" });
	}
}

class SkillTreeSolution {
	public int solution(String skill, String[] skill_trees) {
		int answer = skill_trees.length;
		boolean[] checked;
		for (int i = 0; i < skill_trees.length; i++) {
			checked = new boolean[skill.length()];
			int count = 0;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				//스킬트리 중 하나의 String 선택, 각 문자들 중 스킬에 포함된거 찾아냄
				//i는 문자열 하나를 가르치고, j는 문자하나하나 가르침
				char temp = skill_trees[i].charAt(j);
				if (skill.contains(temp+"")) {
					System.out.println(temp+" 탐색중인거 :"+skill_trees[i]);
					//만약 해당 문자가 skill에서 살펴봐야할 애라면.
					for(int t = 0 ; t < checked.length; t++) {
						//스킬안에 같은 놈 찾으러 떠남.
						if(checked[t] == false) {// 거쳐간 False의 갯수.
							count++;
						}
						if(temp == skill.charAt(t)) {
							if(count > 1) {
								answer--;
								break;//false가 2개 이상나오면 스킬을 스킵했다고 할수있음
							}else {
								count = 0;
								checked[t] = true;//올바르게 스킬배웠다고 체크
								break;
							}
						}
					}
				}
				if(count > 1) {
					break;
				}
			}
		}
		return answer;
	}
}
