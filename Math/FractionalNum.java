package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FractionalNum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int startNum = 1;
		int rise = 1;
		while (true) {
			if (startNum <= num && num < startNum + rise) {
				int left = 1;
				int right = rise;
				for(int i = 0 ; i < num - startNum; i++) {
					left++;
					right--;
				}
				if(rise % 2 == 0) {
					System.out.println(left+"/"+right);
				}else {
					System.out.println(right+"/"+left);
				}
				break;
			}
			startNum += rise;
			rise++;
		}
	}
}
