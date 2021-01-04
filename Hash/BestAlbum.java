package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Collections;

public class BestAlbum {
	public static void main(String args[]) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		BestAlbumSolution s = new BestAlbumSolution();
		s.solution(genres, plays);
	}
}

class BestAlbumSolution {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> totalMap = new HashMap<String, Integer>();
		Song[] songArray = new Song[genres.length];

		for (int i = 0; i < genres.length; i++) {
			songArray[i] = new Song(genres[i], i, plays[i]);
			totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
		}
		int[] answer = new int[totalMap.size() * 2];

		Arrays.sort(songArray);

		Song[] OrderArray = new Song[totalMap.size()];
		int index = 0;
		for (String s : totalMap.keySet()) {
			OrderArray[index++] = new Song(s, totalMap.get(s));
		}
		Arrays.sort(OrderArray);

		index = 0;
		for (int i = 0; i < OrderArray.length; i++) {
			int countSongNum = 0;
			for (int j = 0; j < songArray.length; j++) {
				if (OrderArray[i].genre.equals(songArray[j].genre) && countSongNum < 2) {
					answer[index++] = songArray[j].number;
					countSongNum++;
				}
			}
		}
		int[] answer1 = new int[index];
		for (int i = 0; i < index; i++) {
			answer1[i] = answer[i];
		}
		return answer1;
	}
}

class Song implements Comparable<Song> {
	String genre;
	int number;
	int playCount;

	Song(String genre, int number, int playCount) {
		this.genre = genre;
		this.number = number;
		this.playCount = playCount;
	}

	Song(String genre, int playCount) {
		this.genre = genre;
		this.playCount = playCount;
	}

	@Override
	public int compareTo(Song s) {
		// TODO Auto-generated method stub
		if (this.playCount < s.playCount) {
			return 1;
		} else if (this.playCount > s.playCount) {
			return -1;
		} else {
			if (this.number > s.number) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}