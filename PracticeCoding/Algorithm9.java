package PracticeCoding;

public class Algorithm9 {
	public static void main(String args[]) {
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		Solution9 s9 =new Solution9();
		int[] answer = s9.solution(words, queries);
		for(int a : answer) {
			System.out.print(a+" ");
		}
	}
}

class Solution9 {

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

// 접미사(subffix)용 트라이 구조
		Trie1[] Trie1s = new Trie1[10001];
// 접두사(prefix)용 트라이 구조
		Trie1[] rTrie1s = new Trie1[10001];

// words 길이 별 분류
		for (String word : words) {// word값들 하나씩 넣어서 트라이생성
			// rtrie라는 배열이 10001까지인 이유는 최대 길이가 10000이기 때문임.
			// word의 길이로 접근하므로, 길이를 통해 직관적으로 어떤 루트 노드를 선정할지 결정 할 수 있다.
			// 즉, 루트노드를 선택하면 해당 루트에 딸린 문자열은 모두 같은 길이이다.
			// 문자열을 구성하는 문자 하나하나씩 따라가다보면 이후의 ???을(물음표 3개에 해당되는 문자는 어디에도 대응되며, count로 구분하므로 처리할 수 있다.
			
			int size = word.length();
			// 길이에 해당하는 트라이 만들기
			try {// word길이에 해당되는 루트노드에 접근. null값일 수 있으므로 두 구분으로 나누어 처리.
				Trie1s[size].insert(word.toCharArray()); 
			} catch (Exception e) {
				Trie1s[size] = new Trie1();
				Trie1s[size].insert(word.toCharArray());
			}

			// 반대 문자도 트라이 생성
			word = (new StringBuffer(word)).reverse().toString();
			try {
				rTrie1s[size].insert(word.toCharArray());
			} catch (Exception e) {
				rTrie1s[size] = new Trie1();
				rTrie1s[size].insert(word.toCharArray());
			}
		}

// Trie1 이용하여 해당 쿼리에 맞는 갯수들 찾기
		for (int i = 0; i < queries.length; ++i) {
			String query = queries[i];
			if (query.indexOf('?') == 0) {//앞쪽에 ??xxx의 궂호
				// prefix
				try {
					query = (new StringBuffer(query)).reverse().toString();
					answer[i] = rTrie1s[query.length()].search(query.toCharArray());
					//answer은 queries의 인덱스의 i번째의 해당되는 문자열이 몇개 나오는지 물어보는 것이므로 인덱스 동일.
					//search도 마찬가지로, query(word)의 길이를 통해 루트노드에 최초 접근후에 search를 호출.
				} catch (Exception e) {
					continue;
				}
			}

			else {
				// suffix
				try {
					answer[i] = Trie1s[query.length()].search(query.toCharArray());
				} catch (Exception e) {
					continue;
				}
			}
		}

		return answer;

	}

}

//Trie1 Node
class Trie1 {

	int count;
	Trie1[] childList;

	Trie1() {
		childList = new Trie1[26];
		count = 0;
	}

	void insert(char[] word) {//추가하려는 문자열을 문자 배열로 하여 받음. 각각의 자식을 구성하는 것들은 문자이므로
		Trie1 current = this;//루트노드를 시작으로 하여 자식노드로 이 변수를 통해 접근할 것임.
		for (char no : word) {// 각각의 문자를 추가. 즉 트리구조를 이루기 시작.
			++current.count; // 해당 문자가 추가되었다는건 해당 문자에 이어지는 단어가 추가된것이므로 count를 증가.
								//헷갈릴 수 있는건 중복된 값이 들어와도 왜 count가 추가되냐고 할 수 있지만
								//보니까 중복 처리 안되었네. 
			if (current.childList[no - 'a'] != null) { //하위구조도 루트랑 비슷하게, 해당 문자의 아스키코드로 접근함.
				current = current.childList[no - 'a'];
			} else {//해당 문자가 존재하지 않을 수도 있으므로, 없으면 추가하고 current를 자식 노드로 이동. 
				current.childList[no - 'a'] = new Trie1();//자식 노드를 추가하므로써 빈 깡통의 childList가 또 생긴다고 볼 수 있음.
				current = current.childList[no - 'a'];
			}
		}
	}

	int search(char[] query) {
		Trie1 current = this;//insert와 동일하게 이 변수를 통해 자식노드로 접근.
		for (char no : query) { 
			if (no == '?') {//무조건 xxx???형태로 처리하는 방법으로 설계했으므로 '?'는 가장 마지막에 나올 것임.
							// '?'를 만난경우 이제 그 current.count를 출력해주면 됨.
							// count는 xx?? 의 경우에 ??에 들어갈 수 있는 모든 단어의 갯수
							
			//구체적인 예를 들면, abc까지 추가하는 과정을 본다면
			// 'a'가 추가될 경우 root의 count가 1이 되고, current가 root에서 current.child가 됨
			// 'b'가 추가될 경우 current.child의 count가 1이되고, current가 current.child.childrk 됨
			// 'c'가 추가될 경우 'b'에 해당되는 trie의 count가 1이되고, current는 'c'를 가르킴.
			
			// abd가 추가될 경우, 위와 동일하게 root의 count증가
				// a에 해당되는 trie의 count값 증가.
				// b에 해당되는 trie의 count값 증가.
				
				return current.count;
			}

			if (current.childList[no - 'a'] != null) {// '?' 문자가 나올 때까지 자식 노드로 계속 접근. 
				current = current.childList[no - 'a'];
			} else {
				return 0;
			}
		}
		return current.count;
	}

}