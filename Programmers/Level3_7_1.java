package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Level3_7_1 {
	public static void main(String[] args) {
		solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 });
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		ArrayList<Song> songList = new ArrayList<Song>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		for (int i = 0; i < genres.length; i++) {
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
			songList.add(new Song(i, genres[i], plays[i]));
		}
		ArrayList<Song> totalSongList = new ArrayList<Song>();
		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			totalSongList.add(new Song(0, key, hm.get(key)));
		}
		Collections.sort(totalSongList);
		// 장르별로 재생횟수의 총합을 종합 후 내림차순으로 정렬.

		Collections.sort(songList);
		// 장르 상관없이 각 노래의 재생횟수를 내림차순으로 정렬.

		for (Song s1 : totalSongList) {
			// 각 장르별 최대 2개 출력 가능하므로 체크해줌,
			int count = 0;
			for (Song s2 : songList) {
				if (s1.genre.equals(s2.genre)) {
					count++;
					answerList.add(s2.id);
					if (count > 1) {
						break;
					}
				}
			}
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}
}

class Song implements Comparable<Song> {
	int id;
	String genre;
	int play;

	public Song(int id, String genre, int play) {
		this.id = id;
		this.genre = genre;
		this.play = play;
	}

	@Override
	public int compareTo(Song o) {
		// TODO Auto-generated method stub
		if (o.play > this.play) {
			return 1;
		} else if (o.play < this.play) {
			return -1;
		} else {
			return this.id - o.id;
		}
	}
}
