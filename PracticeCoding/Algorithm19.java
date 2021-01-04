package PracticeCoding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Algorithm19 {
	public static void main(String args[]) {
		Solution19 s19 = new Solution19();
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		s19.solution(genres, plays);
	}
}

class Solution19 {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genresHM = new HashMap<String, Integer>();
		for (int i = 0; i < genres.length; i++) {
			genresHM.put(genres[i], genresHM.getOrDefault(genres[i], 0) + plays[i]);
		}
		// Music[] MusicList = new Music[genresHM.size()];
		//TreeMap<String,Integer> tm = new TreeMap<String,Integer>(genresHM); // 이건 키값으로 정렬
		
		
		LinkedList<Music>[] MusicList = new LinkedList[genresHM.size()];
		Iterator<String> iter = genresHM.keySet().iterator();// 장르, 클래식 이런거 반환.
		int index = 0;
		while (iter.hasNext()) {
			String temp = (String) iter.next();
			MusicList[index] = new LinkedList();
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(temp)) {
					MusicList[index].add( new Music(temp , plays[i], i , genresHM.get(temp)));
				}
			}
			index++;
		}
		
		for (int i = 0; i < MusicList.length; i++) {
			for (int j = 0; j < MusicList[i].size(); j++) {
				System.out.print("genre : "+ MusicList[i].get(j).genre + ", count : "+MusicList[i].get(j).count +", priority : "+MusicList[i].get(j).priority+"  ## ");
			}
			System.out.println();
		}
		int[] answer = {};
		return answer;
	}
}

class Music implements Comparable<Music> {
	String genre;
	int count;
	int priority;
	int sum;

	public Music(String genre, int count, int priority, int sum) {
		this.genre = genre;
		this.count = count;
		this.priority = priority;
		this.sum = sum;
	}

	public Music(String genre, int sum) {
		this.sum = sum;
		this.genre = genre;
	}

	@Override
	public int compareTo(Music o) {
		// TODO Auto-generated method stub
		if(this.count > o.count)
			return 1;
		else if(this.count < o.count)
			return 0;
		return -1;
	}

}