package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChating {
	public static void main(String[] args) {
		solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" });
	}

	public static String[] solution(String[] record) {
		HashMap<String, String> hm = new HashMap<String, String>();
		ArrayList<Chat> chatlist = new ArrayList<Chat>();
		for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			if (info[0].equals("Enter")) {
				chatlist.add(new Chat("Enter", info[1]));
				hm.put(info[1], info[2]);
			}

			else if (info[0].equals("Leave")) {
				chatlist.add(new Chat("Leave", info[1]));
			}

			else if (info[0].equals("Change")) {
				hm.put(info[1], info[2]);
			}
		}
		String[] answer = new String[chatlist.size()];
		for (int i = 0; i < chatlist.size(); i++) {
			answer[i] = hm.get(chatlist.get(i).usrId) + chatlist.get(i).toString();
		}
		return answer;
	}
}

class Chat {
	String str;
	String usrId;

	public Chat(String str, String usrId) {
		this.str = str;
		this.usrId = usrId;
	}

	public String toString() {
		if (str.equals("Enter")) {
			return "님이 들어왔습니다.";
		} else if (str.equals("Leave")) {
			return "님이 나갔습니다.";
		}
		return "";
	}
}