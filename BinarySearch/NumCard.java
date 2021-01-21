package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumCard {// 백준 숫자 카드 2. 10816번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int haveCardNum = Integer.parseInt(br.readLine());
		int[] haveCardArr = new int[haveCardNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < haveCardNum; i++) {
			haveCardArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(haveCardArr);
		int findCardNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < findCardNum; i++) {
			//bw.write(binarySearch(haveCardArr,Integer.parseInt(st.nextToken()))+" ");
			int num = Integer.parseInt(st.nextToken());
			bw.write(upperBound(haveCardArr,num) - lowerBound(haveCardArr,num)+" ");
		}
		bw.flush();
		bw.close();
	}
	private static int lowerBound(int[] data, int target) {//이분탐색의 경우 중복된 값이 있다면, 해당 값을 찾을 때 upperBound, lowerBound를 이용.
	    int begin = 0;
	    int end = data.length;
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(data[mid] >= target) {
	        	end = mid;
	        }
	        else {
	        	begin = mid + 1;
	        }
	    }
	    return end;
	}
	private static int upperBound(int[] data, int target) {
	    int begin = 0;
	    int end = data.length;
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(data[mid] <= target) {
	        	begin = mid + 1;
	        }
	        else {
	        	end = mid;
	        }
	    }
	    return end;
	}
}
/*
 10
-1 -2 -3 -4 -5 -8 -9 -10 -20 -5
8
10 9 -5 2 3 4 5 -10
 */
