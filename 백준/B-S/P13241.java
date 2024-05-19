package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13241 {
//최소공배수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Long> list = new ArrayList<Long>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		list.add((Math.abs(A*B))/GCD(A,B));

		for(long num:list) {
			System.out.println(num);
		}
		
		//자원반납
		br.close();
		
	}
	//최대공약수 구하기
	public static long GCD(long a, long b) {
		if(b==0) {
			return a;
		} else {
			return GCD(b,a%b);
		}
		
	}
	
	
}
