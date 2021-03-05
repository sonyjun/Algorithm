package Programmers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Level1_1_2 {
	public static void main(String[] args) throws ParseException {
		System.out.println(solution(5, 24));
		System.out.println(solution(3, 28));
	}

	public static String solution(int a, int b) throws ParseException {
		String month = "";
		String day = "";
		if (a < 10) {
			month = "0" + a;
		} else {
			month = a + "";
		}
		if (b < 10) {
			day = "0" + b;
		} else {
			day = b + "";
		}
		String inputDate = "2016" + month + day;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = dateFormat.parse(inputDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int answer = calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println(answer);
		switch (answer) {
			case 1: {
				return "SUN";
			}
			case 2: {
				return "MON";
			}
			case 3: {
				return "TUE";
			}
			case 4: {
				return "WED";
			}
			case 5: {
				return "THU";
			}
			case 6: {
				return "FRI";
			}
			case 7: {
				return "SAT";
			}
		}
		return "";
	}
}
