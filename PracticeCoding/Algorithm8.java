package PracticeCoding;

import java.util.LinkedList;
import java.util.TreeSet;

public class Algorithm8 {
	public static void main(String args[]) {
		Solution8 s8 = new Solution8();
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?","?????" };
		int[] answer = s8.solution(words, queries);
		for(int i = 0; i < answer.length ; i ++) {
			System.out.print(answer[i]+" ");
		}
	}
}

class Solution8 {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		Trie trie = new Trie();
		for(int i = 0 ; i < words.length ; i ++) {
			trie.insert(words[i]);//trie노드에 자식들을 다 붙여놓은 상태. 
		}
		
		/*for(int i = 0 ; i < queries.length ; i ++) {
			trie.searchPostQuestion(queries[i]);//trie노드에 자식들을 다 붙여놓은 상태. 
		}*/

		System.out.println(trie.searchPostQuestion(queries[2])+" ");//trie노드에 자식들을 다 붙여놓은 상태. 
		return answer;
	}
	//선형탐색을 이용한 방법.,, 효율성 제로,,
	/*
	public int[] solution1(String[] words, String[] queries) {
		int count = 0;
		int[] answer = new int[queries.length];
		int index = 0;
		TreeSet<String> ts = new TreeSet<String>();
		for(int i = 0 ; i < words.length ; i++) { // 중복제거 과정.
			ts.add(words[i]);
		}
		String[] arr = new String[1]; 
		words = ts.toArray(arr);
		
		
		for (int i = 0; i < queries.length; i++) {// queries의 문자열 하나하나 탐색 for문
			count = 0;
			String compareQuery = queries[i];
			for (int j = 0; j < words.length; j++) {// queries의 임의의 하나 문자열과 비교될 words값 선정.
				String compareWord = words[j];
				if (compareWord.length() == compareQuery.length()) {// 길이 같으면 가능성 있음.
					for (int t = 0; t < compareWord.length(); t++) {
						// 선정된 word하나와 query하나의 각 위치의 문자를 비교.
						if (compareQuery.charAt(t) != '?') {// '?'가 아니라면 비교가 이루어져야함.
															// '?'가 맞으면 상관없이 다음 문자 비교로 넘어감.
							//System.out.println("1");
							if (compareQuery.charAt(t) != compareWord.charAt(t)) {
								break;
							}
						}
						if(t == compareWord.length()-1) {	//만약 마지막 문자열 비교까지 마쳤는데 문제가 없었다는 것. 허용 된다는 것.
															//마지막 까지 문제 없었다면 정답.
							count++;
						}
					}
				}
			}
			answer[index++] = count;
		}
		return answer;
	}*/
	
}

class Trie {//Trie노드는 루트 용도로만 사용됨.

	private TrieNode root;

	/* Constructor */
	public Trie() {
		root = new TrieNode('\u0000'); // 루트 노트생성.
	}

	/**
	 * Function name: insert 추가
	 */
	public void insert(String word) {//word라는 문자열을 추가.
		if (search(word) == true)//해당 문자열이 있다면 추가 x
			return;
		TrieNode current = root;

		for (char ch : word.toCharArray()) {//문자 하나하나씩 추가되도록.
			TrieNode child = current.subNode(ch);//일단 추가하려는 문자열의 일부를 포함한 리프노드까지 도달하기 위함.
			if (child != null) {// 지금 비교하려는 문자는 존재하는 상태이므로, current노드를 자식노드로 옮김.
				current = child;
			} else {// 지금 비교하려는 문자가 존재하지 않는 상태이므로, 현재 노드의 자식노드를 추가해줌.
				current.childList.add(new TrieNode(ch));
				current.countChild++;
				current = current.subNode(ch);
			}
			current.count++;//count는 꼬리가 몇개나 달려있는지 나타내는 용도.
		}
		current.terminal = true;//for문이 다 돌아갔으면 current는 최종적으로 마지막 문자를 저장하고 있는 리프노드 이므로 true를 설정.
	}

	/**
	 * Function name: search 검색
	 */
	public boolean search(String word) { // root노드부터해서 해당 문자열 존재여부 추적.
		TrieNode current = root;

		// 문자열을 문자 배열로 쪼개서 차례대로 비교
		for (char ch : word.toCharArray()) {// 문자열을 문자 배열로 하여 한 문자씩 값이 있는지 확인해봐야함.
			if (current.subNode(ch) == null) // 해당 문자가 없다면,
				return false; // 해당 문자의 노드가 없으면 false리턴 -> 즉 없는 문자열이라고 보면 됨, 단 일부 문자는 존재한다해도 하나라도 일치않하면 없다고 봄.
			else
				current = current.subNode(ch);// 해당 문자가 있다면, 어디까지 있는지 확인을 위해 current라는 노드를 자식노드로 옮김.
		}
		if (current.terminal == true) //모든 탐색이 끝났는데,즉 리프노드까지 도달했다면 있는 문자열이라고 봄.
			return true;

		return false; //모든 탐색이 끝났는데, 리프노드가 아니다 => 일부만 포함된 문자열은 있지만 일치는 하지 않는다는 얘기.
	}
	public boolean searchPreQuestion(String word) { // root노드부터해서 해당 문자열 존재여부 추적.
		TrieNode current = root;

		// 문자열을 문자 배열로 쪼개서 차례대로 비교
		char[] charArr = word.toCharArray();
		for(int i = 0 ; i< charArr.length;i++) {// 문자열을 문자 배열로 하여 한 문자씩 값이 있는지 확인해봐야함.
			if(charArr[i] == '?') {
				
			}else {
				if (current.subNode(charArr[i]) == null) // 해당 문자가 없다면,
					return false; // 해당 문자의 노드가 없으면 false리턴 -> 즉 없는 문자열이라고 보면 됨, 단 일부 문자는 존재한다해도 하나라도 일치않하면 없다고 봄.
				else {
					current = current.subNode(charArr[i]);// 해당 문자가 있다면, 어디까지 있는지 확인을 위해 current라는 노드를 자식노드로 옮김.
				}
			}
			
		}
		if (current.terminal == true) //모든 탐색이 끝났는데,즉 리프노드까지 도달했다면 있는 문자열이라고 봄.
			return true;

		return false; //모든 탐색이 끝났는데, 리프노드가 아니다 => 일부만 포함된 문자열은 있지만 일치는 하지 않는다는 얘기.
	}
	public int searchPostQuestion(String word) { // root노드부터해서 해당 문자열 존재여부 추적.
		TrieNode current = root;
		int sameWord = 0 ;
		// 문자열을 문자 배열로 쪼개서 차례대로 비교
		char[] charArr = word.toCharArray();
		for(int i = 0 ; i< charArr.length;i++) {// 문자열을 문자 배열로 하여 한 문자씩 값이 있는지 확인해봐야함.
			if(charArr[i] == '?') {
				
			}else {
				if (current.subNode(charArr[i]) == null) // 해당 문자가 없다면,
					return 0; // 해당 문자의 노드가 없으면 false리턴 -> 즉 없는 문자열이라고 보면 됨, 단 일부 문자는 존재한다해도 하나라도 일치않하면 없다고 봄.
				else {
					current = current.subNode(charArr[i]);// 해당 문자가 있다면, 어디까지 있는지 확인을 위해 current라는 노드를 자식노드로 옮김.
				}
			}
			
		}
		return sameWord; //모든 탐색이 끝났는데, 리프노드가 아니다 => 일부만 포함된 문자열은 있지만 일치는 하지 않는다는 얘기.
	}
	/**
	 * Function name: remove 제거
	 */
}

/**
 * 트라이 노드 정의
 */
class TrieNode{

	char nodeChar; // 문자저장
	boolean terminal; // 리프 노드 여부
	int count; // 카운드 (해당노드 사용수)
	int countChild; // 카운드 (해당노드 사용수)
	LinkedList<TrieNode> childList; // 자식 노드 리스트

	/* Constructor */
	public TrieNode(char c) {
		childList = new LinkedList<TrieNode>();
		terminal = false;
		nodeChar = c;
		count = 0;
		countChild = 0;
	}

	boolean isTerminal() {
		return terminal;
	}

	// 해당 노드가 가지고 있는 자식 노드들에서 입력받은 문자가 있는지 검사
	public TrieNode subNode(char nextChar) {
		// Type1. 순차 검색.
		if (childList != null) {//자식 노드가 존재한다면,
			for (TrieNode eachChild : childList)//자식 노드들의 리스트를 다 뒤져봄
				if (eachChild.nodeChar == nextChar)//자식 노드들의 문자를 뒤져봤을 때 같은게 나왔다면.
					return eachChild; // 그 해당 노드를 반환.
		}

		return null;// 자식 노드가 존재하지 않는다면, 자식으로 저런 문자를 갖는 놈은 없다고 결론.
	}// subNode()

}// End Class TrieNode
