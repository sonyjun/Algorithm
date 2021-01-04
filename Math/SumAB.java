package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SumAB {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger big1 = new BigInteger(st.nextToken());
		BigInteger big2 = new BigInteger(st.nextToken());
		System.out.println(big1.add(big2));
	}
}
