package Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Level2_1_1 {
	public static void main(String[] args) throws ParseException {
		String m1 = "ABCDEFG";
		String m2 = "CC#BCC#BCC#BCC#B";
		String m3 = "ABC";

		String[] musicinfos1 = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:14,WORLD1,ABCDEF" };
		String[] musicinfos2 = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };
		String[] musicinfos3 = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };

		System.out.println(solution(m1, musicinfos1));
		System.out.println(solution(m2, musicinfos2));
		System.out.println(solution(m3, musicinfos3));

	}

	public static String solution(String m, String[] musicinfos) throws ParseException {
		ArrayList<Music> answer = new ArrayList<Music>();
		String inputM = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#",
				"a");
		for (int i = 0; i < musicinfos.length; i++) {
			String[] currentMusic = musicinfos[i].split(",");// 현재 분석 음악
			String startTime = currentMusic[0];
			String endTime = currentMusic[1];
			String title = currentMusic[2];
			String code = currentMusic[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g")
					.replace("A#", "a");

			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date date1 = dateFormat.parse(startTime);
			Date date2 = dateFormat.parse(endTime);
			long minute = (date2.getTime() - date1.getTime()) / 60000;
			// 재생시간 계산.

			// 재생시간 동안의 코드 흐름 계산.
			String resultCode = "";
			for (int j = 1; j <= (int) minute; j++) {
				if (j > code.length()) {
					resultCode += code.charAt((j - 1) % code.length());
				} else {
					resultCode += code.charAt(j - 1);
				}
			}
			// System.out.println(resultCode);
			if (resultCode.contains(inputM)) {
				answer.add(new Music(minute, title));
			}
		}
		if (answer.size() == 0) {
			return "(None)";
		} else {
			Collections.sort(answer, new Comparator<Music>() {

				@Override
				public int compare(Music o1, Music o2) {
					// TODO Auto-generated method stub
					return (int) o2.playingTime - (int) o1.playingTime;
				}

			});
			return answer.get(0).title;
		}
	}
}

class Music {
	long playingTime;
	String title;
	String code;

	public Music(long playingTime, String title) {
		this.playingTime = playingTime;
		this.title = title;
	}
}
